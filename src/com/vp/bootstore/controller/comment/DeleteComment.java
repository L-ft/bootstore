package com.vp.bootstore.controller.comment;


import com.vp.bootstore.dao.ICommentDao;
import com.vp.bootstore.dao.impl.ICommentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int book_id = Integer.parseInt(request.getParameter("book_id"));

        ICommentDao iCommentDao = new ICommentDaoImpl();
        int a = iCommentDao.delete(book_id);
        if (a>0){
            response.sendRedirect("FindallComment");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
