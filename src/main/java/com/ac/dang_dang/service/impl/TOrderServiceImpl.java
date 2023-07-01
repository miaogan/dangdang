package com.ac.dang_dang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ac.dang_dang.entity.TOrder;
import com.ac.dang_dang.service.TOrderService;
import com.ac.dang_dang.mapper.TOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 75679
 * @description 针对表【t_order】的数据库操作Service实现
 * @createDate 2023-06-26 20:05:31
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder>
        implements TOrderService {
    @Autowired
    TOrderMapper orderMapper;

    @Override
    public Integer UpdateStatus(Integer orderId, String status) {
        return orderMapper.updates(orderId, status);

    }

    @Override
    public List<TOrder> getOrderByUserId(Integer userId) {
        return orderMapper.getOrdersById(userId);
    }
}




