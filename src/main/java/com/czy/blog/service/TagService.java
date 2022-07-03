package com.czy.blog.service;


import com.czy.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 标签接口
 */
public interface TagService {

    Tag saveTag(Tag tag);   //保存标签

    Tag getTag(Long id);      //查询标签

    Tag getTagByName(String name);    //通过名称查询标签

    Page<Tag> listTag(Pageable pageable);   //分页标签

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);

    Tag updateTag(Long id,Tag tag);     //修改标签

    void deleteTag(Long id);      //删除标签
}
