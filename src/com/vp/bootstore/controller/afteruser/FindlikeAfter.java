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

@WebServlet("/FindlikeAfter")
public class FindlikeAfter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String arname = request.getParameter("arname");
        String bumen = request.getParameter("bumen");

        Afteruser afteruser = new Afteruser();
        afteruser.setArname(arname);
        afteruser.setBumen(bumen);

        AfteruserDao afteruserDao = new AfteruserDaoImpl();
        List<Afteruser> afterusers = afteruserDao.findlike(afteruser);
        if (afterusers!=null){
            request.setAttribute("afteruser",afterusers);
            request.getRequestDispatcher("backstage/My_IP.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
