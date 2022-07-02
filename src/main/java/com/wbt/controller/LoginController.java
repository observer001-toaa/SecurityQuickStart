package com.wbt.controller;

import com.wbt.domain.ResponseResult;
import com.wbt.domain.User;
import com.wbt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 15236
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        System.out.println("/user/login");
        //登陆
        return loginService.login(user);
    }
    @RequestMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
