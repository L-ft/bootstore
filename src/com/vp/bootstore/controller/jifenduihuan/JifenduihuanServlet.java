package com.vp.bootstore.controller.jifenduihuan;

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

@WebServlet("/JifenduihuanServlet")
public class JifenduihuanServlet extends HttpServlet {
    private static IOrderDao dao=null;
    private static String[] jh=null;
    private static String[] lhjh=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));//当前页数
        switch (id){
            case 1:
             fenyeselect(request,response);
                break;
            case 2:
               jifenlianhe(request,response);
                break;
            case 3:
                jifenlianhefenye(request,response);
                break;
            case 4:
                huangou(request,response);
                break;
            case 5:
               huangoulianhe(request,response);
                break;
            case 6:
                huangoulianhesyy(request,response);
                break;
            case 7:
                huangouchakan(request,response);
                break;
            case 8:
                jifenchakan(request,response);
                break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    public String zhuanhan(String z){
        if (z==null){
            z="%%";
        }else {
            z="%"+z+"%";
        }
        return z;
    }
    //查询所有并分页
    protected void fenyeselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int ye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据
        int lie=(ye-1)*hang;
        List<Order> orders=dao.jifenlaiyuan(lie,hang);
        int count=dao.jifenlaiyuancount(hang);

        if (orders!=null){
            request.setAttribute("orders",orders);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",1);
            request.setAttribute("pd",1);
            request.getRequestDispatcher("backstage/jifenlaiyuan.jsp").forward(request,response);
        }
    }

    protected void jifenlianhe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        String huiyuan=zhuanhan(request.getParameter("huiyuan"));
        String dingdan=zhuanhan(request.getParameter("dingdan"));

        String jifen=request.getParameter("jifen");
        String spname=request.getParameter("spname");
        String yiji=request.getParameter("yiji");
        String erji=request.getParameter("erji");
        String jifendao="";
        if (jifen.contains("-")){
            jifendao=jifen.substring(jifen.lastIndexOf("-")+1,jifen.length());
            jifen=jifen.substring(0,jifen.lastIndexOf("-"));

        }else {
            jifendao="10000000000";
        }

        if (yiji.contains("所有")){
            yiji="%%";
        }else{
            yiji=zhuanhan(yiji);
        }
        if (erji.contains("所有")||erji.length()==0){
            erji="%%";
        }else{
            erji=zhuanhan(erji);
        }
        if (spname=="所有"){
            spname="%%";
        }else{
            spname=zhuanhan(spname);
        }


       jh=new String[]{huiyuan,dingdan,jifen,jifendao,spname,yiji,erji};
        int ye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据
        int lie=(ye-1)*hang;
        List<Order> orders=dao.jifenlianhe(jh,new int[]{lie,hang});
        int count=dao.jifenlianhecount(jh,hang);

        if (orders!=null){
            request.setAttribute("orders",orders);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",3);
            request.setAttribute("pd",2);
            request.getRequestDispatcher("backstage/jifenlaiyuan.jsp").forward(request,response);
        }
    }

    //上一页下一页
    protected void jifenlianhefenye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();

        int ye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据
        int lie=(ye-1)*hang;
        List<Order> orders=dao.jifenlianhe(jh,new int[]{lie,hang});
        int count=dao.jifenlianhecount(jh,hang);
        System.out.println(count+".........");
        if (orders!=null){
            request.setAttribute("orders",orders);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",3);
            request.setAttribute("pd",2);
            request.getRequestDispatcher("backstage/jifenlaiyuan.jsp").forward(request,response);
        }
    }



    //换购查询所有并分页
    protected void huangou(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int ye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据
        int lie=(ye-1)*hang;
        List<Order> orders=dao.huangou(lie,hang);
        int count=dao.huangoucount(hang);

        if (orders!=null){
            request.setAttribute("orders",orders);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",4);
            request.setAttribute("pd",5);
            request.getRequestDispatcher("backstage/huangou.jsp").forward(request,response);
        }
    }


    protected void huangoulianhe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        String dingdan=zhuanhan(request.getParameter("dingdan"));
        String jifen=request.getParameter("jifen");
        String spname=zhuanhan(request.getParameter("spname"));
        String ztai=zhuanhan(request.getParameter("ztai"));

        String jifendao="";
        if (jifen.contains("-")){
            jifendao=jifen.substring(jifen.lastIndexOf("-")+1,jifen.length());
            jifen=jifen.substring(0,jifen.lastIndexOf("-"));

        }else {
            jifendao="1000000";
        }


        lhjh=new String[]{dingdan,jifen,jifendao,spname,ztai};
        int ye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据
        int lie=(ye-1)*hang;
        List<Order> orders=dao.lianhehuangou(lhjh,new int[]{lie,hang});

        int count=dao.lianhehuangoucount(lhjh,hang);
        if (orders!=null){
            request.setAttribute("orders",orders);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("pd",6);
            request.setAttribute("id",6);
            request.getRequestDispatcher("backstage/huangou.jsp").forward(request,response);
        }
    }

    protected void huangoulianhesyy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int ye=Integer.parseInt(request.getParameter("ye"));//当前页数
        int hang=3;//每页几条数据
        int lie=(ye-1)*hang;
        List<Order> orders=dao.lianhehuangou(lhjh,new int[]{lie,hang});
        int count=dao.lianhehuangoucount(lhjh,hang);
        if (orders!=null){
            request.setAttribute("orders",orders);
            request.setAttribute("ye",ye);
            request.setAttribute("count",count);
            request.setAttribute("id",6);
            request.setAttribute("pd",6);
            request.getRequestDispatcher("backstage/huangou.jsp").forward(request,response);
        }
    }


    //积分换购查看
    protected void huangouchakan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int cid=Integer.parseInt(request.getParameter("cid"));
        String number=request.getParameter("number");
        String name=request.getParameter("name");
        String ye=request.getParameter("ye");
        Order order=dao.huangouchakan(number,name);
        if (order!=null){
            request.setAttribute("order",order);
            request.setAttribute("ye",ye);
            request.setAttribute("id",cid);
            request.getRequestDispatcher("backstage/huangouchakan.jsp").forward(request,response);
        }
    }
    //积分来源查看
    protected void jifenchakan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao=new IOrderDaoImpl();
        int cid=Integer.parseInt(request.getParameter("cid"));
        String number=request.getParameter("number");
        String name=request.getParameter("name");
        String ye=request.getParameter("ye");
        Order order=dao.jifenchakan(number,name);
        if (order!=null){
            request.setAttribute("order",order);
            request.setAttribute("ye",ye);
            request.setAttribute("id",cid);
            request.getRequestDispatcher("backstage/jifenchakan.jsp").forward(request,response);
        }
    }
}
