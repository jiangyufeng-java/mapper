package com.ty.mapper.controller;

import com.ty.mapper.entity.Category;
import com.ty.mapper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 12:00
 **/
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/list")
    public List<Category> list(){
        return categoryService.list();
    }
}
