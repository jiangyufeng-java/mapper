package com.ty.mapper.service;

import com.ty.mapper.entity.Product;

import java.util.List;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 16:45
 **/
public interface ProductService {


    List<Product> findAll();

    Product findById(Integer id);
}
