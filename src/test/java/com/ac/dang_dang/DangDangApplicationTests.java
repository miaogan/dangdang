package com.ac.dang_dang;

import com.ac.dang_dang.DTO.CartBooksDTO;
import com.ac.dang_dang.entity.TBook;
import com.ac.dang_dang.service.impl.TBookServiceImpl;
import com.ac.dang_dang.util.PageBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DangDangApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    TBookServiceImpl tBookService;
    @Test
    void test() {
        List<TBook> list = tBookService.list();
        System.out.println("list = " + list);
    }
    @Test
    void testPage(){
        PageBean page = tBookService.page(1, 1, 1);
        System.out.println("page = " + page);
    }
}
