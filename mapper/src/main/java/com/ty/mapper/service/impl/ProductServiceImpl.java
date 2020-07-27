package com.ty.mapper.service.impl;

import com.ty.mapper.entity.Product;
import com.ty.mapper.mapper.ProductMapper;
import com.ty.mapper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 16:45
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired(required = false)
    private ProductMapper productMapper;


    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findProductAndCategoryName(id);
    }


}
