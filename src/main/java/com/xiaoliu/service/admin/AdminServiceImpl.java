package com.xiaoliu.service.admin;

import com.xiaoliu.constant.RedisCache;
import com.xiaoliu.exception.AppException;
import com.xiaoliu.mapper.admin.AdminMapper;
import com.xiaoliu.pojo.AdminPO;
import com.xiaoliu.until.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 路人甲 on 2019/5/26 12:11
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RedisCache cache;
    @Override
    public Integer insertAdmin(AdminPO adminPO) {

        return adminMapper.insterAdmin(adminPO);
    }


    @Override
    public Integer login(String phone, String password) {
        AdminPO adminPO = adminMapper.selectByPhone(phone);
        cache.hsetObj("token","userinfo",adminPO,25);
        if (adminPO!=null){
            String md5Password = MD5Util.md5Password(password);
            if (!adminPO.getPassword().equals(md5Password)){
                throw new AppException("密码错误");
            }
        }else {
            throw new AppException("请输入正确的手机号");
        }

        return null;
    }

    @Override
    public Integer yanhzneg(AdminPO adminPO) {

        Object toekn = cache.hgetObj("token", "userinfo", AdminPO.class);
        if (toekn == null) {
            throw new AppException("已经过期");

        }
        return null;
    }


}

