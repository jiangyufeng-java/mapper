package com.ty.mapper.comms;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * program : OneCode
 * description :
 * author : jyf
 * date : 2020-07-06 11:51
 **/
@RegisterMapper  // 标记为一个通用mapper的接口  自动去注册
                            // 简单crud 批量crud     根据集合 去crud
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>, IdListMapper<T,Integer> { // 指定好主键类型
}
