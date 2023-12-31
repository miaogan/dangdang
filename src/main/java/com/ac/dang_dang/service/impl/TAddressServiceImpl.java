package com.ac.dang_dang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ac.dang_dang.entity.TAddress;
import com.ac.dang_dang.service.TAddressService;
import com.ac.dang_dang.mapper.TAddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 75679
 * @description 针对表【t_address】的数据库操作Service实现
 * @createDate 2023-06-26 20:05:06
 */
@Service
public class TAddressServiceImpl extends ServiceImpl<TAddressMapper, TAddress>
        implements TAddressService {
    final
    TAddressMapper AddressMapper;

    public TAddressServiceImpl(TAddressMapper AddressMapper) {
        this.AddressMapper = AddressMapper;
    }


    @Override
    public Integer updates(TAddress address) {
        return AddressMapper.updates(address);
    }

    @Override
    public List<TAddress> getAllAddress(Integer userId,Integer addressId) {
        return AddressMapper.getAll(userId,addressId);
    }

    @Override
    public TAddress getSameAddress(TAddress address) {
        return AddressMapper.getSame(address);
    }
}




