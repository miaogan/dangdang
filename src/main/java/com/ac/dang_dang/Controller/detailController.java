package com.ac.dang_dang.Controller;

import com.ac.dang_dang.entity.TBook;
import com.ac.dang_dang.service.impl.TBookServiceImpl;
import com.ac.dang_dang.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detail")
public class detailController {
    final
    TBookServiceImpl BookService;

    public detailController(TBookServiceImpl BookService) {
        this.BookService = BookService;
    }
    @GetMapping("/BookInfo")
    public Result getBookInfo(String name){
        TBook book = BookService.getByName(name);
        return  Result.success(book);
    }
}
