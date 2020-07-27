package com.ty.mapper;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.mapper.util.StringUtil;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.File;
import java.util.Properties;

@SpringBootApplication
@MapperScan("com.ty.mapper.mapper")
public class MapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapperApplication.class, args);
		File file = new File("");
	}
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		//设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
//		properties.setProperty("offsetAsPageNum","true");
		//置为true时，使用RowBounds分页会进行count查询
//		properties.setProperty("rowBoundsWithCount","true");
		//合理化查询,启用合理化时，
		//如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
		//未开启时如果pageNum<1或pageNum>pages会返回空数据
//		properties.setProperty("reasonable","true");
		//配置mysql数据库的方言
		properties.setProperty("dialect","mysql");
		pageHelper.setProperties(properties);
		return pageHelper;
	}


}
