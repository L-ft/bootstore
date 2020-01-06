package com.vp.bootstore.dao.impl;



import com.vp.bootstore.constans.OrderSql;
import com.vp.bootstore.constans.QianTai;
import com.vp.bootstore.dao.IOrderDao;
import com.vp.bootstore.pojo.*;
import com.vp.bootstore.util.DruidPollUtil;
import com.vp.bootstore.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:49
 * @Version: 1.0
 */
public class IOrderDaoImpl implements IOrderDao {
    public static PreparedStatement pre = null;
    public static ResultSet re = null;
    public static Connection con=null;


    @Override
    public List<Order> selectsy(int ye, int hang) {
        return JdbcUtil.executeQuerys(OrderSql.selectsy, new Object[]{ye, hang}, Order.class);
    }

    @Override
    public List<Receiving> selectAddress(int ye, int hang) {
        return JdbcUtil.executeQuerys(OrderSql.selectaddress, new Object[]{ye, hang}, Receiving.class);
    }

    @Override
    public List<BookInfo> selectBookname(int ye, int hang) {
        return JdbcUtil.executeQuerys(OrderSql.selectbookname, new Object[]{ye, hang}, BookInfo.class);
    }

    @Override
    public int selectCoumt(int hang) {
        int count = JdbcUtil.executeCount(OrderSql.selectOrdercount, new Object[]{});

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public int deleteorder(int id) {
        return JdbcUtil.executeNoQuery(OrderSql.deleteOrders, new Object[]{id});
    }

    @Override
    public int orderdetail(int id) {
        return JdbcUtil.executeNoQuery(OrderSql.deleteOrderstail, new Object[]{id});
    }

    @Override
    public List<Order> lianheselect(String[] tj, int[] fy)  {

        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.lianheselectO);
            for (int i = 0; i < tj.length; i++) {
                pre.setString((i + 1), tj[i]);
            }
            for (int j = 6; j < fy.length + 6; j++) {
                pre.setInt(j, fy[j - 6]);
            }

            re = pre.executeQuery();

            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                Receiving r = new Receiving();
                BookInfo book = new BookInfo();
                o.setOrder_id(re.getInt("order_id"));
                o.setOrder_number(re.getString("order_number"));
                o.setUser_id(re.getInt("user_id"));
                r.setReceiving_address(re.getString("receiving_address"));
                o.setOrder_date(re.getTimestamp("order_date"));
                book.setBook_name(re.getString("book_name"));
                o.setOrder_price(re.getDouble("order_price"));
                o.setOrder_status(re.getInt("order_status"));
                o.setReces(r);
                o.setBooks(book);
                list.add(o);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


    public int lhselectCount(Object[] o, int h) {
        int count = JdbcUtil.executeCount(OrderSql.lianhecount, o);

        return count % h == 0 ? count / h : count / h + 1;
    }

    @Override
    public Order dingdanchak(String id, String book) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.dingdanxiangq);
            pre.setString(1, id);
            pre.setString(2, book);
            re = pre.executeQuery();
            Order o = new Order();
            Receiving rev = new Receiving();
            BookInfo books = new BookInfo();
            while (re.next()) {


                o.setOrder_number(re.getString("order_number"));
                o.setUser_id(re.getInt("user_id"));
                rev.setReceiving_address(re.getString("receiving_address"));
                o.setOrder_date(re.getTimestamp("order_date"));
                books.setBook_name(re.getString("book_name"));
                books.setBook_discountprice(re.getDouble("book_discountprice"));
                o.setOrder_price(re.getDouble("order_price"));
                o.setOrder_status(re.getInt("order_status"));
                o.setBooks(books);
                o.setReces(rev);

            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    @Override
    public List<Order> xiaoshou(int ye, int hang) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.xiaoshoue);
            pre.setInt(1, ye);
            pre.setInt(2, hang);
            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                OrderDetail od = new OrderDetail();
                BookInfo book = new BookInfo();
                o.setOrder_id(re.getInt("order_id"));
                book.setBook_press(re.getString("book_press"));
                o.setOrder_number(re.getString("order_number"));
                book.setBook_name(re.getString("book_name"));
                od.setBook_number(re.getInt("book_number"));
                o.setOrder_price(re.getDouble("order_price"));
                o.setOrder_date(re.getTimestamp("order_date"));

                o.setOrderDetails(od);
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int xiaoshouCoumt(int hang) {
        int count = JdbcUtil.executeCount(OrderSql.xiaoshouecount, new Object[]{});

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public List<Order> xiaoshoudtj(String[] tj, int[] fy) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.xiaosoudtjian);
            for (int i = 0; i < tj.length; i++) {
                pre.setString((i + 1), tj[i]);
            }
            for (int j = 4; j < fy.length + 4; j++) {
                pre.setInt(j, fy[j - 4]);
            }
            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                OrderDetail od = new OrderDetail();
                BookInfo book = new BookInfo();
                o.setOrder_id(re.getInt("order_id"));
                book.setBook_press(re.getString("book_press"));
                o.setOrder_number(re.getString("order_number"));
                book.setBook_name(re.getString("book_name"));
                od.setBook_number(re.getInt("book_number"));
                o.setOrder_price(re.getDouble("order_price"));
                o.setOrder_date(re.getTimestamp("order_date"));

                o.setOrderDetails(od);
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int xiaoshoudtjcount(Object[] tj, int hang) {
        int count = JdbcUtil.executeCount(OrderSql.xiaosoudtjiancount, tj);

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public Order xiaosouxiangq(int id, String book) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.xiaosoudtxiangq);
            pre.setInt(1, id);
            pre.setString(2, book);
            re = pre.executeQuery();
            Order o = new Order();
            OrderDetail od = new OrderDetail();
            BookInfo books = new BookInfo();
            while (re.next()) {

                o.setOrder_id(re.getInt("order_id"));
                books.setBook_press(re.getString("book_press"));
                o.setOrder_number(re.getString("order_number"));
                books.setBook_name(re.getString("book_name"));
                od.setBook_number(re.getInt("book_number"));

                o.setOrder_date(re.getTimestamp("order_date"));

                books.setBook_auth(re.getString("book_auth"));
                books.setBook_price(re.getDouble("book_price"));
                books.setBook_discountprice(re.getDouble("book_discountprice"));


                o.setOrderDetails(od);
                o.setBooks(books);

            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }









    //积分来源查询
    @Override
    public List<Order> jifenlaiyuan(int kai,int jie) {

        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.jifenselect);
            pre.setInt(1,kai);
            pre.setInt(2,jie);
            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                BookType t = new BookType();
                BookInfo book = new BookInfo();

                o.setUser_id(re.getInt("user_id"));
                o.setOrder_number(re.getString("order_number"));
                o.setJifen((int)re.getDouble("book_discountprice"));
                book.setBook_name(re.getString("book_name"));
                book.setBook_img(re.getString("book_img"));
                t.setBooktype_name(re.getString("booktype_name"));
                t.setBooktype_detailname(re.getString("booktype_detailname"));
                book.setBook_details(re.getString("book_details"));
                o.setBt(t);
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int jifenlaiyuancount(int hang) {
        int count = JdbcUtil.executeCount(OrderSql.jifenselectcount, new Object[]{});

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    //积分记录联合查询
    @Override
    public List<Order> jifenlianhe(String[] index, int[] fy) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.jifenlianheselect);
            for (int i = 0; i < index.length; i++) {
                pre.setString((i+1),index[i]);
            }
            for (int i = index.length+1; i <= fy.length+index.length; i++) {
                pre.setInt((i),fy[i-index.length-1]);
            }

            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                BookType t = new BookType();
                BookInfo book = new BookInfo();

                o.setUser_id(re.getInt("user_id"));
                o.setOrder_number(re.getString("order_number"));
                o.setJifen((int)re.getDouble("book_discountprice"));
                book.setBook_name(re.getString("book_name"));
                book.setBook_img(re.getString("book_img"));
                t.setBooktype_name(re.getString("booktype_name"));
                t.setBooktype_detailname(re.getString("booktype_detailname"));
                book.setBook_details(re.getString("book_details"));
                o.setBt(t);
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int jifenlianhecount(String[] index1,int hang) {
        int count=0;
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.jifenlianhecount);
            for (int i = 0; i < index1.length; i++) {
                pre.setString((i+1),index1[i]);
            }
            re = pre.executeQuery();
            re.next();
            count=re.getInt(1);
        //  System.out.println(count+"行数");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public List<Order> huangou(int a, int b) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.huangou);
            pre.setInt(1,a);
            pre.setInt(2,b);
            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                BookInfo book = new BookInfo();
                Receiving rev = new Receiving();
                o.setUser_id(re.getInt("user_id"));
                o.setOrder_number(re.getString("order_number"));
                o.setIntegral(re.getInt("integral"));
                book.setBook_name(re.getString("book_name"));
                o.setOrder_date(re.getTimestamp("order_date"));
                o.setOrder_status(re.getInt("order_status"));
                rev.setReceiving_address(re.getString("receiving_address"));
                o.setReces(rev);
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int huangoucount(int hang) {
        int count = JdbcUtil.executeCount(OrderSql.huangoucount, new Object[]{});

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public List<Order> lianhehuangou(String[] index, int[] fy) {

        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.huangoulianhe);

                pre.setString(1,index[0]);
                pre.setInt(2,Integer.parseInt(index[1]));
                pre.setInt(3,Integer.parseInt(index[2]));
                pre.setString(4,index[3]);

                pre.setString(5,index[4]);
                pre.setInt(6,fy[0]);
                pre.setInt(7,fy[1]);


            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                BookInfo book = new BookInfo();
                Receiving rev = new Receiving();
                o.setUser_id(re.getInt("user_id"));
                o.setOrder_number(re.getString("order_number"));
                o.setIntegral(re.getInt("integral"));
                book.setBook_name(re.getString("book_name"));
                o.setOrder_date(re.getTimestamp("order_date"));
                o.setOrder_status(re.getInt("order_status"));
                rev.setReceiving_address(re.getString("receiving_address"));
                o.setReces(rev);
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int lianhehuangoucount(String[] index, int hang) {
        int count=0;
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.huangoulianhecount);
            for (int i = 0; i < index.length; i++) {
                pre.setString((i+1),index[i]);
            }
            re = pre.executeQuery();
            re.next();
            count=re.getInt(1);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public Order huangouchakan(String bh, String name) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.huangouchakan);
            pre.setString(1,bh);
            pre.setString(2,name);
            re = pre.executeQuery();
            Order o = new Order();
            BookInfo book = new BookInfo();
            Receiving rev = new Receiving();
            while (re.next()) {
                o.setUser_id(re.getInt("user_id"));
                o.setOrder_number(re.getString("order_number"));
                o.setIntegral(re.getInt("integral"));
                book.setBook_name(re.getString("book_name"));
                book.setBook_auth(re.getString("book_auth"));
                book.setBook_press(re.getString("book_press"));
                book.setBook_price(re.getDouble("book_price"));
                book.setBook_discountprice(re.getDouble("book_discountprice"));
                o.setOrder_date(re.getTimestamp("order_date"));
                o.setOrder_status(re.getInt("order_status"));
                rev.setReceiving_address(re.getString("receiving_address"));
                o.setReces(rev);
                o.setBooks(book);
            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public Order jifenchakan(String bh, String name) {

        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(OrderSql.jifenchakan);
            pre.setString(1,bh);
            pre.setString(2,name);
            re = pre.executeQuery();
            Order o = new Order();
            BookType t = new BookType();
            BookInfo book = new BookInfo();
            while (re.next()) {


                o.setUser_id(re.getInt("user_id"));
                o.setOrder_number(re.getString("order_number"));
                o.setJifen((int)re.getDouble("book_discountprice"));
                book.setBook_name(re.getString("book_name"));
                book.setBook_img(re.getString("book_img"));
                t.setBooktype_name(re.getString("booktype_name"));
                t.setBooktype_detailname(re.getString("booktype_detailname"));
                book.setBook_details(re.getString("book_details"));
                o.setBt(t);
                o.setBooks(book);

            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }












    @Override
    public List<Order> shenqinagtuihuo(int qi,int hang) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(QianTai.shenqinagtuihuo);
            pre.setInt(1,qi);
            pre.setInt(2,hang);
            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                BookInfo book = new BookInfo();
                o.setOrder_number(re.getString("order_number"));
                book.setBook_img(re.getString("book_img"));
                book.setBook_details(re.getString("book_details"));
                book.setBook_discountprice(re.getDouble("book_discountprice"));
                o.setOrder_price(re.getDouble("order_price"));
                o.setOrder_status(re.getInt("order_status"));
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int tuihuocount(int hang) {
        int count = JdbcUtil.executeCount(QianTai.count, new Object[]{});

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public int kouchujifen(int jf, int id) {

        return JdbcUtil.executeNoQuery(QianTai.kouchujifen,new Object[]{jf,id});
    }

    @Override
    public int tuihuo(String time,String bh) {

        return JdbcUtil.executeNoQuery(QianTai.tuihuo,new Object[]{time,bh});
    }








    //系统信息
    @Override
    public List<Order> xitongxinxi(int qi, int hang) {
        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(QianTai.xitongxinxi);
            pre.setInt(1,qi);
            pre.setInt(2,hang);
            re = pre.executeQuery();
            List<Order> list = new ArrayList<>();
            while (re.next()) {
                Order o = new Order();
                BookInfo book = new BookInfo();
                o.setOrder_number(re.getString("order_number"));
                book.setBook_name(re.getString("book_name"));
                o.setOrder_date(re.getTimestamp("order_date"));
                o.setBooks(book);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int xitongxinxicount(int hang) {
        int count = JdbcUtil.executeCount(QianTai.xitongxinxicount, new Object[]{});

        return count % hang == 0 ? count / hang : count / hang + 1;
    }

    @Override
    public Order xitongxiangqing(String number, String name) {

        try {
            con= DruidPollUtil.getConnection();
            pre = con.prepareStatement(QianTai.xitongxinxixiangq);
            pre.setString(1,number);
            pre.setString(2,name);
            re = pre.executeQuery();
            Order o = new Order();
            OrderDetail d = new OrderDetail();
            BookInfo book = new BookInfo();
            while (re.next()) {
                o.setOrder_number(re.getString("order_number"));
                book.setBook_name(re.getString("book_name"));
                o.setOrder_date(re.getTimestamp("order_date"));
                book.setBook_discountprice(re.getDouble("book_discountprice"));
                d.setBook_number(re.getInt("book_number"));
                o.setOrder_price(re.getDouble("order_price"));
                o.setBooks(book);
                o.setOrderDetails(d);

            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}