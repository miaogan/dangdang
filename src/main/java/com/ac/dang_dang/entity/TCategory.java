package com.ac.dang_dang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_category
 */
@TableName(value ="t_category")
@Data
public class TCategory implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer levels;

    /**
     * 
     */
    private Integer parentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}