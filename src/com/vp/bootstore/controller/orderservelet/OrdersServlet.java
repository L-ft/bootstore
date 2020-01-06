package com.vp.bootstore.controller.orderservelet;




import com.vp.bootstore.dao.IOrderDao;
import com.vp.bootstore.dao.impl.IOrderDaoImpl;
import com.vp.bootstore.pojo.BookInfo;
import com.vp.bootstore.pojo.Order;
import com.vp.bootstore.pojo.Receiving;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;


@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
    private static IOrderDao dao=null;
    private static String[] jh=null;
    private static String[] xsjh=null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));//当前页数
        switch (id){
            case 1:
                chaxunsuoyou(request,response);
                break;
            case 2:
                delete(request,response);
                break;
            case 3:
                lianheselect(request,response);
                break;
            case 4:
                lhfye(request,response);
                break;
            case 5:
                lhdelete(request,response);
                break;
            case 6:
                xiaoshou(request,response);
                break;
            case 7:
                xiaoshoudelete(request,response);
                break;
            case 8:
                xiaosoulianhe(request,response);
                break;
            case 9:
                xiaosoufye(request,response);
                break;
            case 10:
                xiaoshoudtjdelete(request,response);
                break;
            case 11:
               xiaoshoucxun(request,response);
                break;
            case 12:
                dingdanchaxun(request,response);
                break;
            default:
                break;
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
    //查询所有
    protected void chaxunsuoyou(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dqye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据
        int ye=(dqye-1)*hang;
        dao=new IOrderDaoImpl();
        List<Order> orders=dao.selectsy(ye,3);
        List<Receiving> address=dao.selectAddress(ye,3);
        List<BookInfo>  books=dao.selectBookname(ye,3);

        if (orders!=null&&address!=null&&books!=null){
            int zys=dao.selectCoumt(hang);
            request.setAttribute("books",books);
            request.setAttribute("address",address);
            request.setAttribute("ordelist",orders);
            request.setAttribute("ye",dqye);
            request.setAttribute("id",1);
            request.setAttribute("count",zys);
            request.getRequestDispatcher("backstage/Sp_list.jsp").forward(request,response);
        }
    }

    //删除订单
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dqye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据

        dao=new IOrderDaoImpl();
        int oid=Integer.parseInt(request.getParameter("oid"));

        if (dao.deleteorder(oid)>0&&dao.orderdetail(oid)>0){
            int zys=dao.selectCoumt(hang);
            if (dqye>zys&&dqye!=1){
                dqye=zys;
            }
            int ye=(dqye-1)*hang;
            dao=new IOrderDaoImpl();
            List<Order> orders=dao.selectsy(ye,3);
            List<Receiving> address=dao.selectAddress(ye,3);
            List<BookInfo>  books=dao.selectBookname(ye,3);

            request.setAttribute("books",books);
            request.setAttribute("address",address);
            request.setAttribute("ordelist",orders);
            request.setAttribute("ye",dqye);
            request.setAttribute("count",zys);
            request.setAttribute("id",1);
            request.getRequestDispatcher("backstage/Sp_list.jsp").forward(request,response);
        }


    }

    //联合查询 (cha xun和删除)
    protected void lianheselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String oid="%"+request.getParameter("oid")+"%";
        String address="%"+request.getParameter("address")+"%";
        String staus=request.getParameter("staus");
        String congdate=request.getParameter("congdate");
        String daodate=request.getParameter("daodate");
        int ye=Integer.parseInt(request.getParameter("ye"));


        if (Integer.parseInt(staus)==10){
            staus="%%";
        }else {
            staus="%"+staus+"%";
        }
        if (congdate.length()==0){
            congdate="1999-01-01";
        }
        if (daodate.length()==0){
            daodate="5000-01-01";
        }


        dao=new IOrderDaoImpl();
        int count=dao.lhselectCount(new Object[]{oid,address,staus,congdate,daodate},3);
        jh=new String[]{oid,address,staus,congdate,daodate};
        int hang=3;
        int lie=(ye-1)*hang;
        String[] jh=new String[]{oid,address,staus,congdate,daodate};


        List<Order> list= null;
        try {
            list = dao.lianheselect(jh,new int[]{lie,hang});
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (list!=null){


            request.setAttribute("list",list);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",4);


            request.getRequestDispatcher("backstage/Sp_list.jsp").forward(request,response);
        }


    }
    //联合查询分页
    protected void lhfye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int ye=Integer.parseInt(request.getParameter("ye"));
        int hang=3;
        int lie=(ye-1)*hang;
        int count=dao.lhselectCount(jh,3);
        List<Order> list= null;
        try {
            list = dao.lianheselect(jh,new int[]{lie,hang});
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (list!=null){
            request.setAttribute("list",list);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",4);
            request.getRequestDispatcher("backstage/Sp_list.jsp").forward(request,response);
        }

    }
    //联合查询删除订单
    protected void lhdelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dao=new IOrderDaoImpl();
        int oid=Integer.parseInt(request.getParameter("oid"));
        int ye=Integer.parseInt(request.getParameter("ye"));
        if (dao.deleteorder(oid)>0&&dao.orderdetail(oid)>0){
            int count=dao.lhselectCount(jh,3);
            if (ye>count){
                ye--;
            }
            int hang=3;
            int lie=(ye-1)*hang;

            List<Order> list= null;
            try {
                list = dao.lianheselect(jh,new int[]{lie,hang});
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (list!=null){
                request.setAttribute("list",list);
                request.setAttribute("ye",ye);
                request.setAttribute("count",count);
                request.setAttribute("id",4);
                request.getRequestDispatcher("backstage/Sp_list.jsp").forward(request,response);
            }
        }
    }
//销售额查询和分页
    protected void xiaoshou(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int ye=Integer.parseInt(request.getParameter("ye"));
        int hang=3;
        int lie=(ye-1)*hang;
        int count=dao.xiaoshouCoumt(hang);
        List<Order> orlist=dao.xiaoshou(lie,hang);
        if (orlist!=null){
            request.setAttribute("orlist",orlist);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",6);
            request.getRequestDispatcher("backstage/Splkist.jsp").forward(request,response);
        }
    }

    //销售额删除
    protected void xiaoshoudelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int ye=Integer.parseInt(request.getParameter("ye"));
        int id=Integer.parseInt(request.getParameter("oid"));
        int hang=3;
        if (dao.deleteorder(id)>0&&dao.orderdetail(id)>0){
            int count=dao.xiaoshouCoumt(hang);
            if (ye>count&&ye<=1){
                ye=count;
            }
            int lie=(ye-1)*hang;
            List<Order> orlist=dao.xiaoshou(lie,hang);
            request.setAttribute("orlist",orlist);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",6);
            request.getRequestDispatcher("backstage/Splkist.jsp").forward(request,response);
        }
    }
//多条件模糊查询
    protected void xiaosoulianhe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookname=request.getParameter("bookname");
        String cdate=request.getParameter("cdate");
        String ddate=request.getParameter("ddate");

        if (bookname==null){
            bookname="%%";
        }else {
            bookname="%"+bookname+"%";
        }
        if (cdate.length()==0){
            cdate="1999-01-01";
        }
        if (ddate.length()==0){
            ddate="5000-01-01";
        }
        xsjh=new String[] {bookname,cdate,ddate};
        int ye=Integer.parseInt(request.getParameter("ye"));
        int hang=3;
        int lie=(ye-1)*hang;
        int count=dao.xiaoshoudtjcount(new Object[]{xsjh[0],xsjh[1],xsjh[2]},3);
        List<Order> list=dao.xiaoshoudtj(xsjh,new int[]{lie,hang});

        if (list!=null){
            request.setAttribute("list",list);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",9);
            request.getRequestDispatcher("backstage/Splkist.jsp").forward(request,response);
        }

    }
//联合查询分页
    protected void xiaosoufye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int ye=Integer.parseInt(request.getParameter("ye"));
        int hang=3;
        int lie=(ye-1)*hang;
        int count=dao.xiaoshoudtjcount(new Object[]{xsjh[0],xsjh[1],xsjh[2]},3);
        List<Order> list=dao.xiaoshoudtj(xsjh,new int[]{lie,hang});

        if (list!=null){
            request.setAttribute("list",list);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",9);
            request.getRequestDispatcher("backstage/Splkist.jsp").forward(request,response);
        }

    }

    protected void xiaoshoudtjdelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int ye=Integer.parseInt(request.getParameter("ye"));
        int id=Integer.parseInt(request.getParameter("oid"));

        int hang=3;
        if (dao.deleteorder(id)>0&&dao.orderdetail(id)>0){
            int count=dao.xiaoshoudtjcount(new Object[]{xsjh[0],xsjh[1],xsjh[2]},hang);
            System.out.println();
            if (ye>count){
                ye=count;
            }

            int lie=(ye-1)*hang;
            List<Order> list=dao.xiaoshoudtj(xsjh,new int[]{lie,hang});
            request.setAttribute("list",list);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",9);
            request.getRequestDispatcher("backstage/Splkist.jsp").forward(request,response);
        }
    }

    protected void xiaoshoucxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dao=new IOrderDaoImpl();
        int oid=Integer.parseInt(request.getParameter("oid"));
        String ye=request.getParameter("ye");
        String cid=request.getParameter("cid");
        String bookname=request.getParameter("bookname");
        Order or=dao.xiaosouxiangq(oid,bookname);

        if (or!=null){
            request.setAttribute("cid",cid);
            request.setAttribute("ye",ye);
            request.setAttribute("order",or);
            request.getRequestDispatcher("backstage/Sp_tj.jsp").forward(request,response);
        }
    }

    protected void dingdanchaxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dao=new IOrderDaoImpl();
        String cid=request.getParameter("cid");
        String ye=request.getParameter("ye");
        String number=request.getParameter("number");
        String book=request.getParameter("book");
        Order or=dao.dingdanchak(number,book);

        if (or!=null){
            request.setAttribute("cid",cid);
            request.setAttribute("ye",ye);
            request.setAttribute("order",or);
            request.getRequestDispatcher("backstage/dingdanchakan.jsp").forward(request,response);
        }
    }
}
