package com.ac.dang_dang.Controller;

import com.ac.dang_dang.DTO.CategoryDTO;
import com.ac.dang_dang.DTO.CategoryList;
import com.ac.dang_dang.service.impl.TBookServiceImpl;
import com.ac.dang_dang.service.impl.TCategoryServiceImpl;
import com.ac.dang_dang.util.PageBean;
import com.ac.dang_dang.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    final
    TCategoryServiceImpl CategoryService;

    public MainController(TCategoryServiceImpl CategoryService, TBookServiceImpl BookService) {
        this.CategoryService = CategoryService;
        this.BookService = BookService;
    }
    /**
     * 图书选项卡信息
     */
    @GetMapping("/all")
    public Result allCategory(){
        List<CategoryDTO> categoryDTOS = CategoryService.showCategoryWithChild();
        CategoryList categoryList = new CategoryList(categoryDTOS);
        return Result.success(categoryList);
    }

    final
    TBookServiceImpl BookService;
    /**
     * 推荐（采用Rand函数随机推荐）
     */
    @GetMapping("/recommendBooks")
    public Result getRecommendBooks(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean paged = BookService.page(1,page, pageSize);
        return Result.success(paged);
    }
    /**
     * 热销
     */
    @GetMapping("/HotBooks")
    public Result getHotBooks(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean paged = BookService.page(2,page, pageSize);
        return Result.success(paged);
    }
    /**
     * 新上架
     */
    @GetMapping("/NewBooks")
    public Result getNewBooks(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean paged = BookService.page(3,page, pageSize);
        return Result.success(paged);
    }
    /**
     * 新书热卖
     */
    @GetMapping("/NewHotSaleBooks")
    public Result getNewHotSaleBooks(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean paged = BookService.page(4,page, pageSize);
        return Result.success(paged);
    }
}
