package com.ac.dang_dang.DTO;

import lombok.Data;

import java.util.List;
@Data
public class InfoDTO {
    private List<CartBooksDTO> cartBooksDTOList;
    private Double saveMoney;
    private Double realMoney;
}
