package com.ac.dang_dang.Controller;

import com.ac.dang_dang.service.impl.TBookServiceImpl;
import com.ac.dang_dang.util.PageBean;
import com.ac.dang_dang.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class categoryBookController {
    final
    TBookServiceImpl BookService;

    public categoryBookController(TBookServiceImpl BookService) {
        this.BookService = BookService;
    }
    /**
     * 分类显示
     */
    @GetMapping
    public Result pageSearchBooksByCategoryId(Integer pid, Integer cid,
                                              @RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "5") Integer pageSize) {
        PageBean pageBean = BookService.showBooksByCategoryId(pid, cid, pageNum, pageSize);
        return Result.success(pageBean);
    }
    /**
     * 查询
     */
    @GetMapping("/search")
    public Result SearchBooks(@RequestParam(defaultValue = "") String bookName,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize) {
        PageBean pageBean = BookService.searchBooks(bookName, pageNum, pageSize);
        return Result.success(pageBean);
    }
}
