package com.ac.dang_dang.service;

import com.ac.dang_dang.DTO.CategoryDTO;
import com.ac.dang_dang.entity.TCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_category】的数据库操作Service
* @createDate 2023-06-26 20:05:26
*/
public interface TCategoryService extends IService<TCategory> {
    List<CategoryDTO> showCategoryWithChild();
}
