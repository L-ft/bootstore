package com.vp.bootstore.dao.impl;

import com.vp.bookstore.constans.CommentSql;

import com.vp.bookstore.pojo.Comment;

import com.vp.bootstore.dao.ICommentDao;
import com.vp.bootstore.dto.CommentDto;
import com.vp.bootstore.util.DruidPollUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:48
 * @Version: 1.0
 */
public class ICommentDaoImpl implements ICommentDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Comment comment ;
    private CommentDto commentDto;
    private List<CommentDto> commentDtos;
    @Override
    public List<CommentDto> findall() {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(CommentSql.findall);
            rs = ps.executeQuery();
            commentDtos = new ArrayList<>();
            while (rs.next()){
                commentDto = new CommentDto();
                commentDto.setComment_id(rs.getInt("comment_id"));
                commentDto.setUser_id(rs.getInt("book_id"));
                commentDto.setBook_id(rs.getInt("user_id"));
                commentDto.setComment_content(rs.getString("comment_content"));
                commentDto.setComment_date(rs.getTimestamp("comment_date"));
                commentDto.setBook_name(rs.getString("book_name"));

                commentDtos.add(commentDto);
            }
            return commentDtos;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int delete(int comment_id) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(CommentSql.delete);
           ps.setInt(1,comment_id);

           return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int inster(Comment comment) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(CommentSql.inster);
            ps.setInt(1,comment.getComment_id());
            ps.setInt(2,comment.getBook_id());
            ps.setInt(3,comment.getUser_id());
            ps.setString(4,comment.getComment_content());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public List<CommentDto> findbylike(CommentDto commentDto) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(CommentSql.fingbylike);
            ps.setString(1,"%"+commentDto.getComment_content()+"%");
            rs = ps.executeQuery();
            commentDtos = new ArrayList<>();
            while (rs.next()){
                commentDto = new CommentDto();
                commentDto.setComment_id(rs.getInt("comment_id"));
                commentDto.setUser_id(rs.getInt("book_id"));
                commentDto.setBook_id(rs.getInt("user_id"));
                commentDto.setComment_content(rs.getString("comment_content"));
                commentDto.setComment_date(rs.getTimestamp("comment_date"));
                commentDto.setBook_name(rs.getString("book_name"));

                commentDtos.add(commentDto);
            }
            return commentDtos;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
