package com.ac.dang_dang.Controller;

import com.ac.dang_dang.DTO.BookDTO;
import com.ac.dang_dang.DTO.CartBooksDTO;
import com.ac.dang_dang.DTO.UpdateCartDTO;
import com.ac.dang_dang.util.Result;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/Carts")
public class CartController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 加入购物车
     */
    @PostMapping
    public Result addCart(@RequestBody BookDTO bookDTO){
        log.info("接收到的参数为：{}", bookDTO);
        CartBooksDTO items = bookDTO.getItems();
        log.info("items={}", items);
        Integer userId = bookDTO.getUserId();
        log.info("userId = {}", userId);
        // 保存到Redis
        CartBooksDTO cartBooksDTO = bookDTO.getItems();
        String key = "user:" + userId;
        String field = "items:" + cartBooksDTO.getBookId();
        redisTemplate.opsForHash().put(key, field, JSON.toJSONString(cartBooksDTO));
        return Result.success();
    }
    /**
     * 显示信息
     */
    @GetMapping("/{userId}")
    public Result showCart(@PathVariable Integer userId) {
        String key = "user:" + userId;
        Map<Object, Object> cartItemsMap = redisTemplate.opsForHash().entries(key);
        if (cartItemsMap.isEmpty()) {
            log.warn("用户：{}的购物车为空", userId);
            return Result.error("购物车为空");
        }
        List<CartBooksDTO> cartBooksDTOList = new ArrayList<>();
        for (Object cartItem : cartItemsMap.values()) {
            String cartItemStr = (String) cartItem;
            try {
                CartBooksDTO cartBooksDTO = JSON.parseObject(cartItemStr, CartBooksDTO.class);
                cartBooksDTOList.add(cartBooksDTO);
            } catch (Exception e) {
                log.error("反序列化CartBooksDTO对象出错：{}", e.getMessage());
            }
        }
        return Result.success(cartBooksDTOList);
    }
    /**
     * 更改数量
     */
    @PutMapping
    public Result updateCart(@RequestBody UpdateCartDTO updateCartDTO) {
        Integer userId = updateCartDTO.getUserId();
        Integer bookId = updateCartDTO.getBookId();
        Integer count = updateCartDTO.getCount();
        String key = "user:" + userId;
        String field = "items:" + bookId;
        String cartItemStrFromRedis = (String) redisTemplate.opsForHash().get(key, field);
        if (cartItemStrFromRedis == null) {
            log.warn("用户：{}的购物车中不存在ID为：{}的商品", userId, bookId);
            return Result.error("购物车中不存在该商品");
        }
        CartBooksDTO cartBooksDTO;
        try {
            cartBooksDTO = JSON.parseObject(cartItemStrFromRedis, CartBooksDTO.class);
            cartBooksDTO.setCount(count);
        } catch (Exception e) {
            log.error("反序列化CartBooksDTO对象出错：{}", e.getMessage());
            return Result.error("反序列化CartBooksDTO对象出错");
        }
        redisTemplate.opsForHash().put(key, field, JSON.toJSONString(cartBooksDTO));
        return Result.success();
    }
    /**
     * 删除商品
     */
    @DeleteMapping
    public Result DeleteFromCart(Integer userId ,Integer bookId){
        String key = "user:" + userId;
        String field = "items:" + bookId;
        Long result = redisTemplate.opsForHash().delete(key, field);
        if (result == null || result == 0) {
            log.warn("用户：{}的购物车中不存在ID为：{}的商品", userId, bookId);
            return Result.error("购物车中不存在该商品");
        }
        return Result.success();
    }
}
