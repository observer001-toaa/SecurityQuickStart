package com.wbt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wbt.domain.LoginUser;
import com.wbt.domain.User;
import com.wbt.mapper.MenuMapper;
import com.wbt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 15236
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        //查询用户信息
        User user = userMapper.selectOne(queryWrapper);
        //如果没有查询到用户，就抛出异常
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        //TODO 查询对应的权限信息
        List<String> perms = menuMapper.selectPermsByUserId(user.getId());
        //把数据封装成UserDetail返回
        return  new LoginUser(user,perms);
    }
}
