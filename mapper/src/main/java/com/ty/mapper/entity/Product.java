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
 * date : 2020-07-06 11:46
 **/
@Data
public class Product implements Serializable {
        // Mysql支持 Oracle不支持
  //  @GeneratedValue(strategy = GenerationType.IDENTITY) // 执行 insert 操作之后将数据库自动生成的主键值回写到实体类对象中
  //  private String UUID;
    @Id
    @KeySql(useGeneratedKeys=true) // 使用数据库的主键自增长
    private Integer id;

    private Integer categoryId;

    private String productName;
    private Date createTime;
    private Date updateTime;

    @Transient
    private String categoryName;
}
