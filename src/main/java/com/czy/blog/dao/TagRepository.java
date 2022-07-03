package com.czy.blog.dao;

import com.czy.blog.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 操作数据库，增删改查标签
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);


    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
