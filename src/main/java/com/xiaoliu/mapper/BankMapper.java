package com.xiaoliu.mapper;

import com.xiaoliu.pojo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankMapper {
  List<Bank> selectBankByCondition();
  Integer deleteByid(@Param("id")Integer id);
}
