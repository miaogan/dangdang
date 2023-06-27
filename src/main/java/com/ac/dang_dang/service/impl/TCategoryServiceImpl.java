package com.ac.dang_dang.service.impl;

import com.ac.dang_dang.DTO.CategoryDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ac.dang_dang.entity.TCategory;
import com.ac.dang_dang.service.TCategoryService;
import com.ac.dang_dang.mapper.TCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 75679
* @description 针对表【t_category】的数据库操作Service实现
* @createDate 2023-06-26 20:05:26
*/
@Service
@Transactional
public class TCategoryServiceImpl extends ServiceImpl<TCategoryMapper, TCategory>
    implements TCategoryService{
    final
    TCategoryMapper tCategoryMapper;

    public TCategoryServiceImpl(TCategoryMapper tCategoryMapper) {
        this.tCategoryMapper = tCategoryMapper;
    }

    @Override
    public List<CategoryDTO> showCategoryWithChild() {
        return tCategoryMapper.selectCategoryWithChilds();
    }
}




