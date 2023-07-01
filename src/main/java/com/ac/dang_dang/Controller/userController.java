package com.ac.dang_dang.Controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.ac.dang_dang.DTO.UserLoginDTO;
import com.ac.dang_dang.DTO.UserRegisterDTO;
import com.ac.dang_dang.entity.TUser;
import com.ac.dang_dang.service.impl.TUserServiceImpl;
import com.ac.dang_dang.util.Result;
import com.ac.dang_dang.util.SendEmailUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
@RequestMapping("/user")
public class userController {
    final
    TUserServiceImpl UserService;

    public userController(@RequestBody  TUserServiceImpl UserService) {
        this.UserService = UserService;
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody UserLoginDTO user) {
        String nickname=user.getUser().getNickname();
        String password=user.getUser().getPassword();
        String saltByNickName = UserService.getSaltByNickName(nickname);
        System.out.println("saltByNickName = " + saltByNickName);
        String relPassword = DigestUtil.md5Hex(password + saltByNickName);
        System.out.println("relPassword = " + relPassword);
        TUser login = UserService.login(nickname, relPassword);
        System.out.println("login = " + login);
        if (login == null) {
            return Result.error("用户名或密码错误");
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user", login);
        return Result.success(nickname);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result userRegister(@RequestBody UserRegisterDTO userRegisterDTO, HttpServletRequest request) {
        String salt = RandomUtil.randomString(4);
        TUser user = userRegisterDTO.getUser();
        System.out.println("user = " + user);
        String userInputCode = userRegisterDTO.getCaptcha();
        String password = DigestUtil.md5Hex(user.getPassword() + salt);
        user.setSalt(salt);
        String code = RandomUtil.randomString(4);
        user.setCode(code);
        user.setStatus(0);
        user.setPassword(password);
        TUser byEmail = UserService.getByEmail(user.getEmail());
        TUser byNickName = UserService.getByNickName(user.getNickname());
        // 从Session中获取真实的验证码
        String realCode = (String) request.getSession().getAttribute("code");
        System.out.println("realCode = " + realCode);
        if (byEmail != null) {
            return Result.error("邮箱已存在");
        } else if (byNickName != null) {
            return Result.error("昵称已存在");
        } else if (userInputCode == null || !userInputCode.equalsIgnoreCase(realCode)) {
            return Result.error("验证码错误");
        }
        UserService.save(user);
        return Result.success();
    }

    /**
     * 发送邮箱验证
     */
    @PostMapping("/verify")
    public Result userVerify(@RequestBody TUser User) {
        String email = User.getEmail();
        String userCode = User.getCode();
        SendEmailUtil.sendCode(email, userCode);
        return Result.success(email);
    }

    /**
     * 用户激活
     */
    @PostMapping("/activation")
    public Result userActivation(@RequestBody TUser User, String code) {
        String userCode = User.getCode();
        if (userCode.equals(code)) {
            return Result.success();
        }
        return Result.error("激活码错误，请查看邮箱");
    }

    /**
     * 验证码
     */
    @GetMapping("/image")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 创建一个验证码  长，宽，字符数，干扰元素个数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100, 5, 10);
        // 将验证码放到session中以供前端获取展示
        String code = lineCaptcha.getCode();
        //真实验证码
        req.getSession().setAttribute("code", code);
        // 用流写出去
        System.out.println("验证码 = " + code);
        req.setCharacterEncoding("UTF-8");
        lineCaptcha.write(resp.getOutputStream());
    }
}
