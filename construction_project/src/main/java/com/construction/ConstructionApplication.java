package com.construction;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@MapperScan(basePackages = "com.construction.mapper")
public class ConstructionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConstructionApplication.class, args);
    }
    // mp分页插件
//    @Bean
//    public PaginationInnerInterceptor paginationInnerInterceptor() {
//        return new PaginationInnerInterceptor(DbType.MYSQL);
//    }

}
