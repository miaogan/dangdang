package com.ac.dang_dang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_admin
 */
@TableName(value ="t_admin")
@Data
public class TAdmin implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer adminId;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}