package com.ty.mapper.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 11:35
 **/
@Data
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @KeySql(useGeneratedKeys=true)
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}
