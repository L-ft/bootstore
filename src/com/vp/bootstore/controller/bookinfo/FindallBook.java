package com.vp.bootstore.controller.bookinfo;


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

@WebServlet("/findallBook")
public class FindallBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("2122");
        super.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        List<BookInfo> bookInfos = iBookInfoDao.findall();
//        for (BookInfo bookInfo : bookInfos) {
//            System.out.println(bookInfo.toString());
//        }
        request.setAttribute("bookinfos",bookInfos);
        request.getRequestDispatcher("backstage/daily_mykh.jsp").forward(request, response);
    }
}
