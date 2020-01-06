package com.vp.bootstore.dao;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:39
 * @Version: 1.0
 */


import com.vp.bookstore.pojo.Comment;
import com.vp.bootstore.dto.CommentDto;

import java.util.List;

/**
 * 评论表接口
 */
public interface ICommentDao {

    /**
     * 功能：查询所有
     * 传入 null
     * return list comment
     */

    List<CommentDto> findall();

    /**
     * 功能 删除
     * 传入 comment_id
     * return int
     */
    int delete(int comment_id);

    /**
     * 功能 添加
     * 传入 comment
     * return int
     */
    int inster(Comment comment);

    /**
     * 功能 模糊查询
     * 传入 comment
     * return list
     */
    List<CommentDto> findbylike(CommentDto commentDto);
}
