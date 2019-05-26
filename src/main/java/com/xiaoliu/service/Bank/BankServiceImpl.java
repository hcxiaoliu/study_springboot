package com.xiaoliu.service.Bank;

import com.xiaoliu.mapper.bank.BankMapper;
import com.xiaoliu.pojo.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    private BankMapper bankMapper;
    @Override
    public List<Bank> findBankByCondition() {

        return bankMapper.selectBankByCondition();
    }

    @Override
    public Integer deleteByid(Integer id) {
        return bankMapper.deleteByid(id);
    }
}
