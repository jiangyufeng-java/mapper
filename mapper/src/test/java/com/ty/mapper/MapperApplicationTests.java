package com.ty.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.mapper.entity.Category;
import com.ty.mapper.entity.Product;
import com.ty.mapper.mapper.CategoryMapper;
import com.ty.mapper.mapper.ProductMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperApplicationTests {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ProductMapper productMapper;

    @Test
    void test() {
        // 在对象中设置参数,
        // SELECT id,category_name,create_time,update_time FROM category WHERE id = ? AND category_name = ?
        Category c = new Category();
        c.setCategoryName("女装");
        c.setId(1);
        List<Category> select =
                categoryMapper.select(c);
        System.out.println(select);

        // 添加一个
        // insertSelective INSERT INTO category ( id,category_name ) VALUES( ?,? ) 只会插入有值的这样可以使用默认值
        c.setCategoryName("男装");
        c.setId(null);
        categoryMapper.insertSelective(c);
        System.out.println(categoryMapper.select(c));

        // 根据主键
        //SELECT id,category_name,create_time,update_time FROM category WHERE id = ?
        System.out.println(categoryMapper.selectByPrimaryKey(1));


    }


    /**
     * 分页多条件
     * PageHelper
     */
    @Test
    void test2() {
        //　example是Mybatis数据层框架中的一个工具，可以帮我们完成sql语句中where条件句的书写，
        // 相当于where后面的部分，我们可以根据不同的条件来查询和操作数据库，简化书写sql的过程。
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        // and 和 or 都是sql一样的
        criteria.andLike("productName", "%%");  // 设置模糊 是or

        // 设置排序字段
        example.setOrderByClause("create_time ASC");

        //分页  对象
        Page<Object> objects = PageHelper.startPage(1, 5);

        //分页查询
        List<Product> products = productMapper.selectByExample(example);
        // 封装成需要的分页对象
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        System.out.println(products);
        System.out.println(objects);
        System.out.println(pageInfo);
    }

    /**
     * 批量操作
     */
    @Test
    void test3() {
        // 需要指定为 1,2,3  这样的格式
//        productMapper.deleteByIds("1,2,3");

        Product p = new Product();
        // 通过对象里面的条件去 统计
//        productMapper.selectCountByExample(p);

        // 这个也是分页查询  0开始
        RowBounds rowBounds = new RowBounds(1, 5);
        List<Product> products = productMapper.selectByRowBounds(p, rowBounds);
        System.err.println(products);
        products.stream().forEach(System.out::println);

    }

    /**
     * 自定义sql
     */
    @Test
    void test4() {
        Product p = new Product();
        p.setId(4);
        p.setCategoryId(2);
        p.setProductName("御泥坊");
        //Preparing: select * from product WHERE id= ? AND category_id=? AND product_name=?
        // select * from product WHERE id= ?
        List<Product> productByParams = productMapper.findProductByParams(p);
        System.out.println(productByParams);
    }

    /**
     * 添加一个
     */
    @Test
    void test5() {
        Product p = new Product();
        p.setId(4);
        p.setCategoryId(2);
        p.setProductName("黑美人");
        //  update product   set category_id=?, product_name=? where id = ?
        productMapper.update(p);

    }

    /**
     * 添加集合
     */
    @Test
    void test6() {
        Product p = new Product();

        p.setCategoryId(2);
        p.setProductName("白美人");
        Product p1 = new Product();
        p1.setCategoryId(2);
        p1.setProductName("黄美人");
        //  update product   set category_id=?, product_name=? where id = ?
        List<Product> lists = new ArrayList<>();
        lists.add(p);
        lists.add(p1);
        // insert into product (category_id,product_name) values (?,?) , (?,?)
        productMapper.insertProductList(lists);

    }


    //把方法提取出来了(创建一个example对象)
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Product.class);
        //　example是Mybatis数据层框架中的一个工具，可以帮我们完成sql语句中where条件句的书写，
        // 相当于where后面的部分，我们可以根据不同的条件来查询和操作数据库，简化书写sql的过程。
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");//品牌名字的模糊查询
            }
            if (searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))) {//letter品牌的首字母
                criteria.andEqualTo("letter", (String) searchMap.get("letter"));//品牌首字母精确查询
            }
        }
        return example;
    }

    @Test
    void test7() {
        Object o = "hello";
        String s = (String) o;
        System.out.println(s);
    }
    @Test
    public void test8() throws Exception {



    }



}
