package com.czy.blog.service;

import com.czy.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 分类接口
 */
public interface TypeService {

    Type saveType(Type type);   //保存分类

    Type getType(Long id);      //查询分类

    Type getTypeByName(String name);    //通过名称查询分类

    Page<Type> listType(Pageable pageable);   //分页查询

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id,Type type);     //修改分类

    void deleteType(Long id);      //删除分类
}
