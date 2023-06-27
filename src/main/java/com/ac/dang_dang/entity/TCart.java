package com.ac.dang_dang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_cart
 */
@TableName(value ="t_cart")
@Data
public class TCart implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer cartId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String bookName;

    /**
     * 
     */
    private Integer bookId;

    /**
     * 
     */
    private Integer quantity;

    /**
     * 
     */
    private Double price;

    /**
     * 
     */
    private Double dprice;

    /**
     * 
     */
    private Date createDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}