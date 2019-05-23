package com.xiaoliu.service;

import com.xiaoliu.pojo.Bank;

import java.util.List;

public interface BankService

{

    /**
     * 按照条件不分页查找银行名称
     *
     * @return
     */
    public List<Bank> findBankByCondition(Bank bank);
}
