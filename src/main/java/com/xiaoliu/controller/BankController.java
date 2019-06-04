package com.xiaoliu.controller;

import com.xiaoliu.constant.RedisCache;
import com.xiaoliu.pojo.Bank;
import com.xiaoliu.service.Bank.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Api(description = "测试管理")
@RestController
@RequestMapping("/Bank")
public class BankController {
    @Autowired
    private BankService bankService;
    @Autowired
    private RedisCache cache;


    @ApiOperation(value = "加载所有")
    @GetMapping("/getAllBank")
    public List<Bank> getAllBank(){
        return bankService.findBankByCondition();
    }



    @ApiOperation(value = "根据银行id删除")
    @DeleteMapping("/deleteByID")
    public Integer deleteByID(Integer id){
        return bankService.deleteByid(id);
    }


    @ApiOperation(value = "设置对象到redis中")
    @GetMapping("/setRedis")
    public Map<String, String> setRedis(String key,String value){
//        cache.set(key,value);
//        String s = cache.get(key); //返回的是value
        List<Bank> list = bankService.findBankByCondition();
        Bank bank = list.get(0);
        Long aLong = cache.hsetObj(key, value, bank, 10023);
        Map<String, String> map = cache.hgetAll(key);
        return map;
    }

    @ApiOperation(value = "获取对象到redis中")
    @GetMapping("/getRedis")
    public Map<String, String> getRedis(String key){
        Map<String, String> map = cache.hgetAll(key);
        return map;
    }

    @ApiOperation(value = "freemaker")
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("index");
        List<Bank> bank = bankService.findBankByCondition();
        mv.addObject("bank", bank);
        return  mv;
    }
}
