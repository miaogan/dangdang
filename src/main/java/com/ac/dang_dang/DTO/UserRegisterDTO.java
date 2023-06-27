package com.ac.dang_dang.DTO;

import com.ac.dang_dang.entity.TUser;
import lombok.Data;

@Data
public class UserRegisterDTO {
    private TUser user;
    private String captcha;
}
