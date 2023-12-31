package com.ac.dang_dang.service;

import com.ac.dang_dang.entity.TAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_address】的数据库操作Service
* @createDate 2023-06-26 20:05:06
*/
public interface TAddressService extends IService<TAddress> {
    Integer updates(TAddress address);

    List<TAddress> getAllAddress(Integer userId,Integer addressId);

    TAddress getSameAddress(TAddress address);
}
