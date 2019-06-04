package com.xiaoliu.controller;


import com.xiaoliu.service.email.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 路人甲 on 2019/5/30 22:58
 */

@Api(description = "sendemail")
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    EmailService mailService;

    @ApiOperation(value = "发送邮件")
    @GetMapping("/sendMail")
    public void send(String toMail,String subject,String content){
            mailService.sendSimpleMail(subject,toMail,content);

    }

}
