package com.xiaoliu.service.admin;

import com.xiaoliu.pojo.AdminPO;

/**
 * Created by 路人甲 on 2019/5/26 12:11
 */
public interface AdminService {
    Integer insertAdmin(AdminPO adminPO);

    Integer login(String phone, String password);

    Integer yanhzneg(AdminPO adminPO);
}
