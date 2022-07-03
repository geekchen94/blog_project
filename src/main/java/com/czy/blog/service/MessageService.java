/**
 * Copyright (C), 2015-2020, LSTAR
 * FileName: MessageService
 * Author:   OneStar
 * Date:     2020/3/5 22:48
 * Description: 留言接口
 * History:
 * <author>          <time>          <version>          <desc>
 * oneStar           修改时间           版本号              描述
 */
package com.czy.blog.service;

import com.czy.blog.po.Message;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈留言接口〉
 *
 */
public interface MessageService {
    List<Message> listMessage();
    Message saveMessage(Message message);
    void deleteMessage(Long id);
}