package com.ty.mapper.VO;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 11:46
 **/
@Data
public class ProductVO implements Serializable {

    private Integer id;

    private Integer categoryId;

    private String productName;
    private Date createTime;
    private Date updateTime;

    private String categoryName;
}
