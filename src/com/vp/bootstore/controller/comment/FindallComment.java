package com.vp.bootstore.controller.comment;


import com.vp.bootstore.dao.ICommentDao;
import com.vp.bootstore.dao.impl.ICommentDaoImpl;
import com.vp.bootstore.dto.CommentDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindallComment")
public class FindallComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICommentDao iCommentDao = new ICommentDaoImpl();
        List<CommentDto> commentDtos = iCommentDao.findall();

        request.setAttribute("commentdtos",commentDtos);
        request.getRequestDispatcher("backstage/daily_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
