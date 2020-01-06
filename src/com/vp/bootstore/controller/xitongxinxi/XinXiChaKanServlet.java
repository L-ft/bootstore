package com.vp.bootstore.controller.xitongxinxi;

import com.vp.bootstore.dao.IOrderDao;
import com.vp.bootstore.dao.impl.IOrderDaoImpl;
import com.vp.bootstore.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/XinXiChaKanServlet")
public class XinXiChaKanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number=request.getParameter("number");
        String ye=request.getParameter("ye");
        String name=request.getParameter("name");
        IOrderDao dao=new IOrderDaoImpl();
        Order order=dao.xitongxiangqing(number,name);
        if (order!=null){
            request.setAttribute("order",order);
            request.setAttribute("ye",ye);
            request.getRequestDispatcher("qiantai/user_9xiangqing.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
