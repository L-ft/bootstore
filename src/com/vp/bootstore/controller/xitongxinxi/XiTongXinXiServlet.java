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
import java.util.List;

@WebServlet("/XiTongXinXiServlet")
public class XiTongXinXiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ye=Integer.parseInt(request.getParameter("ye"));//当前页数
        System.out.println(ye);
        IOrderDao dao=new IOrderDaoImpl();
        int hang=3;//每页几条数据
        int count=dao.xitongxinxicount(hang);
        if(ye>count){
            ye=count;
        }
        int lie=(ye-1)*hang;
        List<Order> olist=dao.xitongxinxi(lie,hang);
        if (olist!=null){
            request.setAttribute("olist",olist);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.getRequestDispatcher("qiantai/user_9.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
