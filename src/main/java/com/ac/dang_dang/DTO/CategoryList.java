package com.ac.dang_dang.DTO;

import java.util.List;

public class CategoryList {
    private List<CategoryDTO> categoryDTOS;

    public CategoryList(List<CategoryDTO> categoryDTOS) {
        this.categoryDTOS = categoryDTOS;
    }

    public List<CategoryDTO> getCategoryDTOS() {
        return categoryDTOS;
    }

    public void setCategoryDTOS(List<CategoryDTO> categoryDTOS) {
        this.categoryDTOS = categoryDTOS;
    }
}
