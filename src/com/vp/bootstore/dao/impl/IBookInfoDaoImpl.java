package com.vp.bootstore.dao.impl;

import com.vp.bookstore.constans.BookInfoSql;

import com.vp.bootstore.dao.IBookInfoDao;
import com.vp.bootstore.pojo.BookInfo;
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
 * @Date: 2019/12/23 13:48
 * @Version: 1.0
 */
public class IBookInfoDaoImpl implements IBookInfoDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private BookInfo bookInfo;
    private List<BookInfo> bookInfos;

    @Override
    public BookInfo findByBookId(int id) {
        return null;
    }

    @Override
    public List<BookInfo> findHeatRanking(int size) {
        return null;
    }

    @Override
    public List<BookInfo> findNewBookRanking(int size) {
        return null;
    }

    @Override
    public List<BookInfo> findDisCountBookRanking(int size) {
        return null;
    }

    @Override
    public List<BookInfo> findall() {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.findall);
            rs = ps.executeQuery();
            bookInfos = new ArrayList<>();
            while (rs.next()){
                bookInfo = new BookInfo();
                bookInfo.setBook_id(rs.getInt("book_id"));
                bookInfo.setBook_name(rs.getString("book_name"));
                bookInfo.setBook_price(rs.getDouble("book_price"));
                bookInfo.setBook_discountprice(rs.getDouble("book_discountprice"));
                bookInfo.setBook_details(rs.getString("book_details"));
                bookInfo.setBook_status(rs.getInt("book_status"));
                bookInfo.setBook_typeid(rs.getInt("book_typeid"));
                bookInfo.setBook_fitclass(rs.getInt("book_fitclass"));
                bookInfo.setBook_auth(rs.getString("book_auth"));
                bookInfo.setBook_press(rs.getString("book_press"));
                bookInfo.setBook_date(rs.getTimestamp("book_date"));


                bookInfos.add(bookInfo);
            }
            return bookInfos;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int delete(int book_id) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.delete);
            ps.setInt(1,book_id);

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }


    public List<BookInfo> findLike(BookInfo bookInfo) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.findlike);
            ps.setString(1,"%"+bookInfo.getBook_name()+"%");
            ps.setString(2,"%"+bookInfo.getBook_auth()+"%");
            ps.setString(3,"%"+bookInfo.getBook_press()+"%");



            rs = ps.executeQuery();
            bookInfos = new ArrayList<>();
            while (rs.next()){
                bookInfo = new BookInfo();
                bookInfo.setBook_id(rs.getInt("book_id"));
                bookInfo.setBook_name(rs.getString("book_name"));
                bookInfo.setBook_price(rs.getDouble("book_price"));
                bookInfo.setBook_discount(rs.getDouble("book_discount"));
                bookInfo.setBook_discountprice(rs.getDouble("book_discountprice"));
                bookInfo.setBook_status(rs.getInt("book_status"));
                bookInfo.setBook_typeid(rs.getInt("book_typeid"));
                bookInfo.setBook_fitclass(rs.getInt("book_fitclass"));
                bookInfo.setBook_auth(rs.getString("book_auth"));
                bookInfo.setBook_press(rs.getString("book_press"));
                bookInfo.setBook_date(rs.getTimestamp("book_date"));
                bookInfo.setBook_details(rs.getString("book_details"));
                bookInfos.add(bookInfo);
            }
            return bookInfos;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<BookInfo> shenhefindLike(BookInfo bookInfo) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.shenhefindlike );
            ps.setString(1,"%"+bookInfo.getBook_name()+"%");
            ps.setString(2,"%"+bookInfo.getBook_auth()+"%");
            ps.setString(3,"%"+bookInfo.getBook_press()+"%");
            if (bookInfo.getBook_status()==3){

                ps.setString(4,"%%");
            }else {
                ps.setString(4,"%"+bookInfo.getBook_status()+"%");
            }


            rs = ps.executeQuery();
            bookInfos = new ArrayList<>();
            while (rs.next()){
                bookInfo = new BookInfo();
                bookInfo.setBook_id(rs.getInt("book_id"));
                bookInfo.setBook_name(rs.getString("book_name"));
                bookInfo.setBook_price(rs.getDouble("book_price"));
                bookInfo.setBook_discount(rs.getDouble("book_discount"));
                bookInfo.setBook_discountprice(rs.getDouble("book_discountprice"));
                bookInfo.setBook_status(rs.getInt("book_status"));
                bookInfo.setBook_typeid(rs.getInt("book_typeid"));
                bookInfo.setBook_fitclass(rs.getInt("book_fitclass"));
                bookInfo.setBook_auth(rs.getString("book_auth"));
                bookInfo.setBook_press(rs.getString("book_press"));
                bookInfo.setBook_date(rs.getTimestamp("book_date"));
                bookInfo.setBook_details(rs.getString("book_details"));
                bookInfos.add(bookInfo);
            }
            return bookInfos;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int inster(BookInfo bookInfo) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.inster);

            ps.setString(1,bookInfo.getBook_name());
            ps.setDouble(2,bookInfo.getBook_price());
            ps.setDouble(3,bookInfo.getBook_discount());

            ps.setString(4,bookInfo.getBook_img());

            ps.setInt(5,bookInfo.getBook_status());
            ps.setInt(6,bookInfo.getBook_typeid());
            ps.setInt(7,bookInfo.getBook_fitclass());
            ps.setString(8,bookInfo.getBook_auth());

            ps.setInt(9,bookInfo.getBook_isexchange());
            ps.setString(10,bookInfo.getBook_press());

            ps.setInt(11,bookInfo.getBook_stock());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public List<BookInfo> findbybook_discount() {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.fingbook_discount);
            rs = ps.executeQuery();
            bookInfos = new ArrayList<>();
            while (rs.next()){
                bookInfo = new BookInfo();
                bookInfo.setBook_id(rs.getInt("book_id"));
                bookInfo.setBook_name(rs.getString("book_name"));
                bookInfo.setBook_price(rs.getDouble("book_price"));
                bookInfo.setBook_discountprice(rs.getDouble("book_discountprice"));
                bookInfo.setBook_details(rs.getString("book_details"));
                bookInfo.setBook_status(rs.getInt("book_status"));
                bookInfo.setBook_typeid(rs.getInt("book_typeid"));
                bookInfo.setBook_fitclass(rs.getInt("book_fitclass"));
                bookInfo.setBook_auth(rs.getString("book_auth"));
                bookInfo.setBook_press(rs.getString("book_press"));
                bookInfo.setBook_date(rs.getTimestamp("book_date"));


                bookInfos.add(bookInfo);
            }
            return bookInfos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BookInfo> findbybook_status() {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.findbybook_status);
            rs = ps.executeQuery();
            bookInfos = new ArrayList<>();
            while (rs.next()){
                bookInfo = new BookInfo();
                bookInfo.setBook_id(rs.getInt("book_id"));
                bookInfo.setBook_name(rs.getString("book_name"));
                bookInfo.setBook_price(rs.getDouble("book_price"));
                bookInfo.setBook_discountprice(rs.getDouble("book_discountprice"));
                bookInfo.setBook_details(rs.getString("book_details"));
                bookInfo.setBook_status(rs.getInt("book_status"));
                bookInfo.setBook_typeid(rs.getInt("book_typeid"));
                bookInfo.setBook_fitclass(rs.getInt("book_fitclass"));
                bookInfo.setBook_auth(rs.getString("book_auth"));
                bookInfo.setBook_press(rs.getString("book_press"));
                bookInfo.setBook_date(rs.getTimestamp("book_date"));


                bookInfos.add(bookInfo);
            }
            return bookInfos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookInfo shenhechaxun(int id) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.shenhechaxun);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            bookInfo = new BookInfo();
            while (rs.next()){

                bookInfo.setBook_id(rs.getInt("book_id"));
                bookInfo.setBook_name(rs.getString("book_name"));
                bookInfo.setBook_price(rs.getDouble("book_price"));
                bookInfo.setBook_discount(rs.getDouble("book_discount"));
                bookInfo.setBook_img(rs.getString("book_img"));
                bookInfo.setUserid(rs.getInt("userid"));
                bookInfo.setBook_isexchange(rs.getInt("book_isexchange"));
                bookInfo.setBook_stock(rs.getInt("book_stock"));
                bookInfo.setBook_discountprice(rs.getDouble("book_discountprice"));
                bookInfo.setBook_details(rs.getString("book_details"));
                bookInfo.setBook_status(rs.getInt("book_status"));
                bookInfo.setBook_typeid(rs.getInt("book_typeid"));
                bookInfo.setBook_fitclass(rs.getInt("book_fitclass"));
                bookInfo.setBook_auth(rs.getString("book_auth"));
                bookInfo.setBook_press(rs.getString("book_press"));
                bookInfo.setBook_date(rs.getTimestamp("book_date"));



            }
            return bookInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int shenhetg(int id, int sid) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.shenhexiugai);
            ps.setInt(1,id);
            ps.setInt(2,sid);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
               if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public boolean insertBookInfo(BookInfo bookInfo,Integer userid) {
        String book_name = bookInfo.getBook_name();
        Double book_price = bookInfo.getBook_price();
        Double book_discount = bookInfo.getBook_discount();
        Double book_discountprice = bookInfo.getBook_discountprice();
        String book_details = bookInfo.getBook_details();
        Integer book_status=0;
        Integer book_typeid = bookInfo.getBook_typeid();
        Integer book_fitclass = bookInfo.getBook_fitclass();
        String book_auth = bookInfo.getBook_auth();
        Integer id=userid;
        Integer book_isexchange = bookInfo.getBook_isexchange();
        String book_press = bookInfo.getBook_press();
        Integer book_stock = bookInfo.getBook_stock();
        int i = JdbcUtil.executeNoQuery(BookInfoSql.insertBookInfo, new Object[]{book_name,book_price,book_discount,book_discountprice,book_details,book_status,book_typeid,book_fitclass,book_auth,id,book_isexchange,book_stock,book_stock});
        if (i>0){
            return true;
        }
        return false;

    }

    @Override
    public BookInfo findid(int book_id) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(BookInfoSql.findid);
            ps.setInt(1,book_id);
            rs = ps.executeQuery();

            while (rs.next()){
                bookInfo = new BookInfo();
                bookInfo.setBook_id(rs.getInt("book_id"));
                bookInfo.setBook_name(rs.getString("book_name"));
                bookInfo.setBook_price(rs.getDouble("book_price"));
                bookInfo.setBook_discountprice(rs.getDouble("book_discountprice"));
                bookInfo.setBook_details(rs.getString("book_details"));
                bookInfo.setBook_status(rs.getInt("book_status"));
                bookInfo.setBook_typeid(rs.getInt("book_typeid"));
                bookInfo.setBook_fitclass(rs.getInt("book_fitclass"));
                bookInfo.setBook_auth(rs.getString("book_auth"));
                bookInfo.setBook_press(rs.getString("book_press"));
                bookInfo.setBook_date(rs.getTimestamp("book_date"));



            }
            return bookInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
