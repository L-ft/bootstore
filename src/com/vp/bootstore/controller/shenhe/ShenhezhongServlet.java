package com.vp.bootstore.controller.shenhe;

import com.vp.bootstore.dao.IBookInfoDao;
import com.vp.bootstore.dao.impl.IBookInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShenhezhongServlet")
public class ShenhezhongServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id"));
        int shenhe=Integer.parseInt(request.getParameter("shenhe"));

        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        int i=iBookInfoDao.shenhetg(shenhe,id);
        if (i>0){
           // System.out.println("成功");
            response.sendRedirect("FindBookstatus");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
