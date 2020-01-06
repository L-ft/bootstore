package com.vp.bootstore.controller.bookinfo;


import com.vp.bookstore.pojo.Afteruser;
import com.vp.bootstore.dao.IBookInfoDao;
import com.vp.bootstore.dao.impl.IBookInfoDaoImpl;
import com.vp.bootstore.pojo.BookInfo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/InsterBook")
public class InsterBook extends HttpServlet {
    private IBookInfoDao bookInfoDao=new IBookInfoDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        BookInfo book=new BookInfo();
        book.setBook_name(request.getParameter("book_name"));
        double book_price = Double.parseDouble(request.getParameter("book_price"));
        book.setBook_price(book_price);
        double book_discount = Double.parseDouble(request.getParameter("book_discount"));
        book.setBook_discount(book_discount);
        book.setBook_discountprice(book_price*book_discount);
        book.setBook_details(request.getParameter("book_details"));
        book.setBook_typeid(Integer.parseInt(request.getParameter("book_typeid")));
        book.setBook_fitclass(Integer.parseInt(request.getParameter("book_fitclass")));
        book.setBook_auth(request.getParameter("book_auth"));
        book.setBook_isexchange(Integer.parseInt(request.getParameter("book_isexchange")));
        book.setBook_press(request.getParameter("book_press"));
        book.setBook_stock(Integer.parseInt(request.getParameter("bookStock")));
        HttpSession session = request.getSession();
        Afteruser login = (Afteruser) session.getAttribute("login");
        boolean b = bookInfoDao.insertBookInfo(book, login.getArid());
        response.sendRedirect("findallBook");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}