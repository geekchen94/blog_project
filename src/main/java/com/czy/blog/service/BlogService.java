package com.czy.blog.service;

import com.czy.blog.vo.BlogQuery;
import com.czy.blog.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * 博客
 */
public interface BlogService {

    Blog getBlog(Long id);      //查询

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);    //分页查询

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);           //新增

    Blog updateBlog(Long id,Blog blog);    //修改

    void deleteBlog(Long id);    //删除
}
