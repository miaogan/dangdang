package com.ac.dang_dang.mapper;

import com.ac.dang_dang.entity.TBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_book】的数据库操作Mapper
* @createDate 2023-06-26 20:05:23
* @Entity com.ac.dang_dang.entity.TBook
*/
@Mapper
public interface TBookMapper extends BaseMapper<TBook> {
    List<TBook> getRecommendBooks();

    List<TBook> getHotBooks();

    List<TBook> getNewBooks();

    List<TBook> getNewHotSaleBooks();

    List<TBook> selectBooksByCategoryId(Integer pid, Integer cid);
    List<TBook> selectByName(String bookName);
    @Select("select *from t_book where book_name=#{name}")
    TBook getBooksByName(String name);
}




