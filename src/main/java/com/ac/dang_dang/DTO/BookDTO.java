package com.ac.dang_dang.DTO;

import com.ac.dang_dang.entity.TBook;
import lombok.Data;

/**
 * @author 75679
 */
@Data
public class BookDTO{
    private TBook book;
    private Integer userId;
}
