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
    Integer update(TAddress address);

    List<TAddress> getAllAddress(String userId);

    TAddress getSameAddress(TAddress address);
}
