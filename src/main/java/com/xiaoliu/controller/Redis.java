package com.xiaoliu.controller;

import com.xiaoliu.constant.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 路人甲 on 2019/5/26 1:11
 */
public class Redis {
    @Autowired
    RedisCache cache;

    public String ss() {

            return cache.set("name", "xiaoliu");
        }
        public String getssB () {
            return cache.get("name");
        }

}
