package com.xiaoliu.controller;

import com.xiaoliu.pojo.AdminPO;
import com.xiaoliu.service.admin.AdminService;
import com.xiaoliu.until.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 路人甲 on 2019/5/26 12:13
 */
@Api(description = "管理员控制层")
@RestController
@RequestMapping("/admin")
public class TestEmail {
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/insertAdmin")
    public Integer insertAdmin(@RequestBody AdminPO adminPO){
        adminPO.setRegtime(new Date());
        String md5Password = MD5Util.md5Password(adminPO.getPassword());
        adminPO.setPassword(md5Password);
        return adminService.insertAdmin(adminPO);

    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/login")
    public Integer Login(String password,String phone){
        return adminService.login(phone,password);
    }


}
