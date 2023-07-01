package com.ac.dang_dang.DTO;

import com.ac.dang_dang.entity.TBook;
import lombok.Data;

import java.util.Map;

@Data
public class BookDTO {
    private CartBooksDTO items;
    private Integer userId;
}