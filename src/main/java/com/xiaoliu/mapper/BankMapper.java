package com.xiaoliu.mapper;

import com.xiaoliu.pojo.Bank;

import java.util.List;

public interface BankMapper {
  List<Bank> selectBankByCondition();
}
