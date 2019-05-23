package com.xiaoliu.service;

import com.xiaoliu.mapper.BankMapper;
import com.xiaoliu.pojo.Bank;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BankServiceImpl implements  BankService {

    @Autowired
    private BankMapper bankMapper;
    @Override
    public List<Bank> findBankByCondition(Bank bank) {
        return bankMapper.selectBankByCondition();
    }
}
