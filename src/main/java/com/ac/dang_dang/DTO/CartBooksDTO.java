package com.ac.dang_dang.DTO;

import lombok.Data;

@Data
public class CartBooksDTO {
    private Integer count;
    private Double price;
    private Double dprice;
    private Integer bookId;
    private String bookName;
}
