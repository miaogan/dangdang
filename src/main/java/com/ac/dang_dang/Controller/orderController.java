package com.ac.dang_dang.Controller;

import com.ac.dang_dang.DTO.BookDTO;
import com.ac.dang_dang.entity.TBook;
import com.ac.dang_dang.entity.TItem;
import com.ac.dang_dang.entity.TUser;
import com.ac.dang_dang.service.impl.TOrderServiceImpl;
import com.ac.dang_dang.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/order")
public class orderController {
    final
    TOrderServiceImpl OrderService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    public orderController(TOrderServiceImpl OrderService) {
        this.OrderService = OrderService;
    }
    /**
     * 加入购物车
     */

    @PostMapping
    public Result addItem(@RequestBody BookDTO bookDTO){
        log.info("接收到的参数为：{}", bookDTO);
        TBook tBook = bookDTO.getBook();
        log.info("tBook = {}", tBook);
        Integer userId = bookDTO.getUserId();
        System.out.println("userId = " + userId);
        return Result.success(bookDTO);
    }
}
