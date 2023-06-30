package com.ac.dang_dang;

import com.ac.dang_dang.service.RedisTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DangDangApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    RedisTestService redisTestService;
    @Test
    void test(){
        redisTestService.add();
    }
    @Test
    void test2(){
        System.out.println(redisTestService.get(290));
    }
}
