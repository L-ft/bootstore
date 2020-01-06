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
import java.util.List;

@WebServlet("/FindBookstatus")
public class FindBookstatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        List<BookInfo> bookInfoList = iBookInfoDao.findbybook_discount();
//        for (BookInfo bookInfo : bookInfoList) {
//            System.out.println(bookInfo.toString());
//        }
        request.setAttribute("bookinfo",bookInfoList);
        request.getRequestDispatcher("backstage/shenhe.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
