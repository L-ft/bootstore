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

@WebServlet("/InsterShenhe")
public class InsterShenhe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        String book_name = request.getParameter("book_name");
        Double book_price = Double.parseDouble(request.getParameter("book_price"));
        Double book_discount = Double.parseDouble(request.getParameter("book_discount"));
        Double book_discountprice = Double.parseDouble(request.getParameter("book_discountprice"));
        String book_img = request.getParameter("book_img");
        String book_details = request.getParameter("book_details");
        int book_status = Integer.parseInt(request.getParameter("book_status"));
        int book_typeid = Integer.parseInt(request.getParameter("book_typeid"));
        int book_fitclass = Integer.parseInt(request.getParameter("book_fitclass"));
        String book_auth = request.getParameter("book_auth");
        int userid = Integer.parseInt(request.getParameter("userid"));
        int book_isexchange = Integer.parseInt(request.getParameter("book_isexchange"));
        String book_press = request.getParameter("book_press");
        int book_collection = Integer.parseInt(request.getParameter("book_collection"));
        int book_sell = Integer.parseInt(request.getParameter("book_sell"));
        int bookStock = Integer.parseInt(request.getParameter("bookStock"));

        System.out.println(book_id);

        BookInfo bookInfo = new BookInfo();
        bookInfo.setBook_id(book_id);
        bookInfo.setBook_name(book_name);
        bookInfo.setBook_price(book_price);
        bookInfo.setBook_discount(book_discount);
        bookInfo.setBook_discountprice(book_discountprice);
        bookInfo.setBook_img(book_img);
        bookInfo.setBook_details(book_details);
        bookInfo.setBook_status(book_status);
        bookInfo.setBook_typeid(book_typeid);
        bookInfo.setBook_fitclass(book_fitclass);
        bookInfo.setBook_auth(book_auth);
        bookInfo.setUserid(userid);
        bookInfo.setBook_isexchange(book_isexchange);
        bookInfo.setBook_press(book_press);
        bookInfo.setBook_collection(book_collection);
        bookInfo.setBook_sell(book_sell);
        bookInfo.setBook_stock(bookStock);

        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        int a = iBookInfoDao.inster(bookInfo);


        if (a>0){

            response.sendRedirect("FindBookstatus");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
