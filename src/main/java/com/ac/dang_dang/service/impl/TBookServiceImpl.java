package com.ac.dang_dang.service.impl;

import com.ac.dang_dang.util.PageBean;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ac.dang_dang.entity.TBook;
import com.ac.dang_dang.service.TBookService;
import com.ac.dang_dang.mapper.TBookMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 75679
 * @description 针对表【t_book】的数据库操作Service实现
 * @createDate 2023-06-26 20:05:23
 */
@Transactional
@Service
public class TBookServiceImpl extends ServiceImpl<TBookMapper, TBook>
        implements TBookService {
    private final TBookMapper BookMapper;

    public TBookServiceImpl(TBookMapper BookMapper) {
        this.BookMapper = BookMapper;
    }

    @Override
    public PageBean page(Integer id, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<TBook> Books = null;
        if (id == 1) {
            Books = BookMapper.getRecommendBooks();
        }
        if (id == 2) {
            Books = BookMapper.getHotBooks();
        }
        if (id == 3) {
            Books = BookMapper.getNewBooks();
        }
        if (id == 4) {
            Books = BookMapper.getNewHotSaleBooks();
        }
        Page<TBook> books = (Page<TBook>) Books;
        PageBean pageBean = new PageBean(books.getTotal(), books.getResult());
        return pageBean;
    }

    @Override
    public PageBean showBooksByCategoryId(Integer pid, Integer cid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TBook> tBooks = BookMapper.selectBooksByCategoryId(pid, cid);
        Page<TBook> books = (Page<TBook>) tBooks;
        PageBean pageBean = new PageBean(books.getTotal(), books.getResult());
        return pageBean;
    }

    @Override
    public PageBean searchBooks(String bookName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TBook> tBooks = BookMapper.selectByName(bookName);
        Page<TBook> books = (Page<TBook>) tBooks;
        PageBean pageBean = new PageBean(books.getTotal(), books.getResult());
        return pageBean;
    }

    @Override
    public TBook getByName(String name) {
        return BookMapper.getBooksByName(name);
    }
}




