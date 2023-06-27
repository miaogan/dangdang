package com.ac.dang_dang.service;

import com.ac.dang_dang.entity.TBook;
import com.ac.dang_dang.util.PageBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_book】的数据库操作Service
* @createDate 2023-06-26 20:05:23
*/
public interface TBookService extends IService<TBook> {
    PageBean page(Integer id, Integer page, Integer pageSize);

    PageBean showBooksByCategoryId(Integer pid, Integer cid, Integer pageNum, Integer pageSize);

    PageBean searchBooks(String bookName, Integer pageNum, Integer pageSize);

    TBook getByName(String name);
}
