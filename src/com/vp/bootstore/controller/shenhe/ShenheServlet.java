package com.vp.bootstore.controller.shenhe;

import com.vp.bootstore.dao.IBookInfoDao;
import com.vp.bootstore.dao.impl.IBookInfoDaoImpl;
import com.vp.bootstore.pojo.BookInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShenheServlet")
public class ShenheServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int id=Integer.parseInt(request.getParameter("id"));
        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        BookInfo book=iBookInfoDao.shenhechaxun(id);
        if (book!=null){
            request.setAttribute("book",book);
            request.getRequestDispatcher("backstage/tongguo.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
