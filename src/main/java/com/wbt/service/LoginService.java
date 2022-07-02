package com.wbt.service;

import com.wbt.domain.ResponseResult;
import com.wbt.domain.User;

/**
 * @author 15236
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
