package com.vp.bootstore.controller.afteruser;


import com.vp.bootstore.dao.AfteruserDao;
import com.vp.bootstore.dao.impl.AfteruserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteAfter")
public class DeleteAfter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int arid = Integer.parseInt(request.getParameter("arid"));

        AfteruserDao afteruserDao = new AfteruserDaoImpl();
        int a = afteruserDao.delete(arid);
        if (a>0){
            response.sendRedirect("FindAll");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
