package com.vp.bootstore.controller.afteruser;


import com.vp.bookstore.pojo.Afteruser;
import com.vp.bootstore.dao.AfteruserDao;
import com.vp.bootstore.dao.impl.AfteruserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindByArid")
public class FindByArid extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        AfteruserDao afteruserDao = new AfteruserDaoImpl();
        Afteruser afterusers = afteruserDao.findbyarid(id);
        if (afterusers!=null){
            request.setAttribute("afterusers",afterusers);
            request.getRequestDispatcher("backstage/HuiFangJL_tj.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
