package com.ac.dang_dang.mapper;

import com.ac.dang_dang.DTO.CategoryDTO;
import com.ac.dang_dang.entity.TCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_category】的数据库操作Mapper
* @createDate 2023-06-26 20:05:26
* @Entity com.ac.dang_dang.entity.TCategory
*/
@Mapper
public interface TCategoryMapper extends BaseMapper<TCategory> {
    List<CategoryDTO> selectCategoryWithChilds();
}




