package com.ac.dang_dang.service.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ac.dang_dang.entity.TUser;
import com.ac.dang_dang.service.TUserService;
import com.ac.dang_dang.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 75679
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2023-06-26 20:05:34
 */
@Service
@Transactional
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
        implements TUserService {
    @Autowired
    TUserMapper userMapper;

    @Override
    public TUser getByEmail(String email) {
        return userMapper.getByEmail(email);
    }

    @Override
    public TUser getByNickName(String nickname) {
        return userMapper.getByNickName(nickname);
    }

    @Override
    public String getSaltByNickName(String nickname) {
        return userMapper.getSaltByNickName(nickname);
    }

    @Override
    public TUser login(String nickname, String relPassword) {
        return userMapper.login(nickname, relPassword);
    }
}




