package com.ac.dang_dang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_address
 */
@TableName(value ="t_address")
@Data
public class TAddress implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer addressId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String mobile;

    /**
     * 
     */
    private String province;

    /**
     * 
     */
    private String city;

    /**
     * 
     */
    private String district;

    /**
     * 
     */
    private String town;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}