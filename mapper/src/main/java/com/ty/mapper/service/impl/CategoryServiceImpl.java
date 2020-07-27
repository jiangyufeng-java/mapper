package com.ty.mapper.service.impl;

import com.ty.mapper.entity.Category;
import com.ty.mapper.mapper.CategoryMapper;
import com.ty.mapper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 11:59
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.selectAll();
    }
}
