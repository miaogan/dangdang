package com.ac.dang_dang.mapper;

import com.ac.dang_dang.entity.TAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_address】的数据库操作Mapper
* @createDate 2023-06-26 20:05:06
* @Entity com.ac.dang_dang.entity.TAddress
*/
@Mapper
public interface TAddressMapper extends BaseMapper<TAddress> {
    Integer updates(TAddress address);
    List<TAddress> getAll(Integer userId,Integer addressId);
    @Select("select * from  t_address where name=#{name} and mobile=#{mobile} and province=#{province} and city=#{city} and district=#{district} and town=#{town} " +
            "and address=#{address} and user_id=#{userId}")
    TAddress getSame(TAddress address);
}




