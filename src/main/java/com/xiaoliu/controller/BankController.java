package com.xiaoliu.controller;

import com.xiaoliu.pojo.Bank;
import com.xiaoliu.service.Bank.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "银行管理")
@RestController
@RequestMapping("/Bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @ApiOperation(value = "加载所有银行")
    @GetMapping("/getAllBank")
    public List<Bank> getAllBank(){
        return bankService.findBankByCondition();
    }

    @ApiOperation(value = "根据银行id删除")
    @DeleteMapping("/deleteByID")
    public Integer deleteByID(Integer id){
        return bankService.deleteByid(id);
    }
}
