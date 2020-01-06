package com.vp.bootstore.controller.tuihuo;

import com.vp.bootstore.dao.IOrderDao;
import com.vp.bootstore.dao.impl.IOrderDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/TuiHuoServlet")
public class TuiHuoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jifen=(int)Double.parseDouble(request.getParameter("jifen"));
        String number=request.getParameter("number");
        String ye=request.getParameter("ye");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());
        IOrderDao dao=new IOrderDaoImpl();
        int id=1;//这是登陆用户的id，
        if (dao.kouchujifen(jifen,id)>0&&dao.tuihuo(time,number)>0){
            request.setAttribute("ye",ye);
            request.getRequestDispatcher("TuiHuoshenqingServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
