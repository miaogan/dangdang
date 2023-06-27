package com.ac.dang_dang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName t_book
 */
@TableName(value ="t_book")
@Data
public class TBook implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer bookId;

    /**
     * 
     */
    private String bookName;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private String cover;

    /**
     * 
     */
    private String press;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pressDate;

    /**
     * 
     */
    private String edition;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date printDate;

    /**
     * 
     */
    private String impression;

    /**
     * 
     */
    private String isbn;

    /**
     * 
     */
    private Integer wordNum;

    /**
     * 
     */
    private Integer pageNum;

    /**
     * 
     */
    private String sizes;

    /**
     * 
     */
    private String paper;

    /**
     * 
     */
    private String pack;

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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    /**
     * 
     */
    private String editorRecommend;

    /**
     * 
     */
    private String contentAbstract;

    /**
     * 
     */
    private String authorAbstract;

    /**
     * 
     */
    private String director;

    /**
     * 
     */
    private String mediaCommentary;

    /**
     * 
     */
    private Integer categoryId;

    /**
     * 
     */
    private Integer sale;

    /**
     * 
     */
    private Integer stock;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}