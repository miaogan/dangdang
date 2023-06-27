package com.ac.dang_dang.DTO;

import com.ac.dang_dang.entity.TCategory;
import lombok.Data;

import java.util.List;
@Data
public class CategoryDTO extends TCategory {
    private List<TCategory> childCategoryList;
}
