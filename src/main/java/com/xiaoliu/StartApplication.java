package com.xiaoliu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.xiaoliu.mapper")
@EnableSwagger2
public class StartApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartApplication.class, args);
    }

}
