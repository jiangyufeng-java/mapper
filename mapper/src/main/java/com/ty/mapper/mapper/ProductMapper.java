package com.ty.mapper.mapper;

import com.ty.mapper.comms.BaseMapper;
import com.ty.mapper.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 11:50
 **/
public interface ProductMapper extends BaseMapper<Product> {

    Product findProductAndCategoryName(Integer id);

//    @Select("select * from product")
    List<Product> findProductByParams(Product p);

    int update(Product p);

    int insertProductList( List<Product> pros);
}
