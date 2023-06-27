package com.ac.dang_dang.mapper;

import com.ac.dang_dang.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author 75679
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-06-26 20:05:34
* @Entity com.ac.dang_dang.entity.TUser
*/
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {
    @Select("select * from t_user where email =#{email}")
    TUser getByEmail(String email);
    @Select("select * from t_user where nickname=#{nickname}")
    TUser getByNickName(String nickname);
    @Select("select salt from t_user where nickname=#{nickname}")
    String getSaltByNickName(String nickname);
    @Select("select * from t_user where nickname=#{nickname} and password=#{relPassword}")
    TUser login(String nickname, String relPassword);
}




