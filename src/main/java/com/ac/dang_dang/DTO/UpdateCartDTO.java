package com.ac.dang_dang.DTO;

import lombok.Data;

@Data
public class UpdateCartDTO {
    private Integer userId;  // 用户ID
    private Integer bookId;  // 商品ID
    private Integer count;   // 商品数量

    // 省略getter和setter方法
}