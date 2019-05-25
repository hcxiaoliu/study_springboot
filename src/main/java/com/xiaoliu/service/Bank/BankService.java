package com.xiaoliu.service.Bank;

import com.xiaoliu.pojo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface BankService {

     List<Bank> findBankByCondition();
     Integer deleteByid(Integer id);
}
