package com.construction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
