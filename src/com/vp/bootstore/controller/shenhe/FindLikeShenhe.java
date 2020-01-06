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

@WebServlet("/FindLikeshenheBook")
public class FindLikeShenhe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String book_name = request.getParameter("book_name");
        String book_auth = request.getParameter("book_auth");
        String book_press = request.getParameter("book_press");
        int sh = Integer.parseInt(request.getParameter("shenhe"));

        System.out.println(book_name+book_auth+book_press+sh);

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBook_name(book_name);
        bookInfo.setBook_auth(book_auth);
        bookInfo.setBook_press(book_press);
        bookInfo.setBook_status(sh);
        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        List<BookInfo> bookInfos = iBookInfoDao.shenhefindLike(bookInfo);

        request.setAttribute("bookinfo",bookInfos);
        request.getRequestDispatcher("backstage/shenhe.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
