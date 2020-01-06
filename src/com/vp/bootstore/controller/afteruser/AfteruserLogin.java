package com.vp.bootstore.controller.afteruser;

import com.vp.bookstore.pojo.Afteruser;
import com.vp.bootstore.dao.AfteruserDao;
import com.vp.bootstore.dao.impl.AfteruserDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AfteruserLogin")
public class AfteruserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String arname =  request.getParameter("arname");
        String arpassword = request.getParameter("arpassword");

        Afteruser afteruser = new Afteruser();
        afteruser.setArname(arname);
        afteruser.setArpassword(arpassword);


        AfteruserDao afteruserDao = new AfteruserDaoImpl();
        Afteruser login = afteruserDao.login(afteruser);

        if (login!=null){
            HttpSession session = request.getSession();
            session.setAttribute("login",login);
            response.sendRedirect("backstage/child.jsp");
        }else {
            response.sendRedirect("backstage/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
