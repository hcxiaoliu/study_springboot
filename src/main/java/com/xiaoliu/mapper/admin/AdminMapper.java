package com.xiaoliu.mapper.admin;

import com.xiaoliu.pojo.AdminPO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 路人甲 on 2019/5/26 11:53
 */
public interface AdminMapper {

    Integer insterAdmin(AdminPO admin);


    AdminPO selectByPhone(@Param("phone") String phone);
}
