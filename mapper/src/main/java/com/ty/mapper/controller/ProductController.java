package com.ty.mapper.controller;

import com.ty.mapper.entity.Product;
import com.ty.mapper.mapper.ProductMapper;
import com.ty.mapper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 16:46
 **/
@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/product/list")
    public List<Product> findAll(){
        List<Product> all = productService.findAll();
        System.out.println();
        return all;
    }

    @GetMapping("/product/find/{id}")
    public Product findById(@PathVariable(value = "id") Integer id){
        return productService.findById(id);
    }
}
