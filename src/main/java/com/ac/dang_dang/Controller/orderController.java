package com.ac.dang_dang.Controller;

import com.ac.dang_dang.DTO.BookDTO;
import com.ac.dang_dang.entity.TBook;
import com.ac.dang_dang.entity.TOrder;
import com.ac.dang_dang.service.impl.TOrderServiceImpl;
import com.ac.dang_dang.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/order")
public class orderController {
    final
    TOrderServiceImpl OrderService;

    public orderController(TOrderServiceImpl OrderService) {
        this.OrderService = OrderService;
    }

    /**
     * 创造订单
     */
    @PostMapping
    public Result CreatedOrder(@RequestBody TOrder order) {
        OrderService.save(order);
        return Result.success(order);
    }
    /**
     * 修改订单状态
     */
    @PutMapping
    public Result PutOrder(Integer orderId, String status) {
        Integer integer = OrderService.UpdateStatus(orderId, status);
        if (integer==1){
            return Result.success();
        }else {
            return Result.error("操作失败");
        }

    }
    /**
     * 删除订单
     */
    @DeleteMapping
    public Result DeleteOrder(@RequestBody List<Integer>orderIds){
        boolean b = OrderService.removeByIds(orderIds);
        if (b) {
            return Result.success();
        }else {
            return Result.error("删除失败");
        }
    }
    /**
     * 获取所有订单
     */
    @GetMapping
    public Result GetOrder(Integer userId){
        List<TOrder> orders = OrderService.getOrderByUserId(userId);

        Map<String, Object> data = new HashMap<>();
        data.put("orders", orders);
        return Result.success(data);
    }
}
