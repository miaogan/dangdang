package com.ac.dang_dang.service;

import com.ac.dang_dang.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 75679
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-06-26 20:05:34
*/
public interface TUserService extends IService<TUser> {


    TUser getByEmail(String email);

    TUser getByNickName(String nickname);

    String getSaltByNickName(String nickname);

    TUser login(String nickname, String relPassword);
}
