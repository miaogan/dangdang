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
 * @TableName t_item
 */
@TableName(value ="t_item")
@Data
public class TItem implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer itemId;

    /**
     * 
     */
    private Integer bookId;

    /**
     * 
     */
    private Integer count;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private Integer orderId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}