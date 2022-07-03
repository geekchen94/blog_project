package com.czy.blog.service;

import com.czy.blog.po.Comment;

import java.util.List;

/**
 * 评论接口实现
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

    void deleteComment(Long id);
}
