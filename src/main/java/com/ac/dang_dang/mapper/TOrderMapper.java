package com.ac.dang_dang.mapper;

import com.ac.dang_dang.entity.TOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2023-06-26 20:05:31
* @Entity com.ac.dang_dang.entity.TOrder
*/
@Mapper
public interface TOrderMapper extends BaseMapper<TOrder> {
    @Update("UPDATE t_order set status =#{status} where order_id=#{orderId}")
    Integer updates(Integer orderId,String status);
    @Select("select *from t_order where user_id=#{userId}")
    List<TOrder> getOrdersById(Integer userId);
}




