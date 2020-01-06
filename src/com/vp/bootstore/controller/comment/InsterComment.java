package com.vp.bootstore.controller.comment;

import com.vp.bookstore.pojo.Comment;
import com.vp.bootstore.dao.ICommentDao;
import com.vp.bootstore.dao.impl.ICommentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsterComment")
public class InsterComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int comment_id = Integer.parseInt(request.getParameter("comment_id"));
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String comment_content = request.getParameter("comment_content");

        Comment comment = new Comment();
        comment.setComment_id(comment_id);
        comment.setBook_id(book_id);
        comment.setUser_id(user_id);
        comment.setComment_content(comment_content);

        ICommentDao iCommentDao = new ICommentDaoImpl();
        int a = iCommentDao.inster(comment);
        if (a>0){
            response.sendRedirect("FindallComment");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
