package com.wbt.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 15236
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    @PreAuthorize("hasAnyAuthority('system:test:list')")
    public String hello(){
        return "hello"
                ;
    }
}
