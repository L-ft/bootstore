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

@WebServlet("/FindLikeBook")
public class FindLikeBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String book_name = request.getParameter("book_name");
        String book_auth = request.getParameter("book_auth");
        String book_press = request.getParameter("book_press");

        System.out.println(book_name+book_auth+book_press);

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBook_name(book_name);
        bookInfo.setBook_auth(book_auth);
        bookInfo.setBook_press(book_press);

        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        List<BookInfo> bookInfos = iBookInfoDao.findLike(bookInfo);

        request.setAttribute("bookinfos",bookInfos);
        request.getRequestDispatcher("backstage/daily_mykh.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
