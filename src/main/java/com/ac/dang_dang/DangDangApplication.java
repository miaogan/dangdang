package com.ac.dang_dang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAspectJAutoProxy
@SpringBootApplication

public class DangDangApplication {

    public static void main(String[] args) {
        SpringApplication.run(DangDangApplication.class, args);
    }

}
