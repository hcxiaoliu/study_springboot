package com.xiaoliu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * Created by 路人甲 on 2019/6/4 21:48
 */
@Api(description = "")
@RestController
@RequestMapping("/session")

public class SessionController {



    @ApiOperation(value = "获取seession")
    @GetMapping("/getSession")
    public String getSession(HttpSession session){
        session.setAttribute("test","测试");

    return (String) session.getAttribute("one");
    }



}
