package com.vp.bookstore.constans;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:59
 * @Version: 1.0
 */

/**
 * 书籍表的Sql语句
 */
public class BookInfoSql {

    //查询所有书籍
    public static final String findall = "SELECT book_id ,book_name,book_price,book_discountprice,book_details,book_status,book_typeid,book_fitclass,book_auth,book_press,book_date FROM bookinfo";

    //删除
    public static final String delete = "DELETE FROM bookinfo WHERE book_id = ?";

    //模糊查询
    public static final String findlike = " SELECT * FROM bookinfo WHERE book_name LIKE ? AND  book_auth LIKE ? AND book_press LIKE ?  ";
    public static final String shenhefindlike = " SELECT * FROM bookinfo WHERE book_name LIKE ? AND  book_auth LIKE ? AND book_press LIKE ? and book_status like ? ";

    //添加
    public static final String inster = "INSERT INTO `bookstore`.`bookinfo` (`book_name`, `book_price`, `book_discount`, `book_img`, `book_details`, `book_typeid`, `book_fitclass`, `book_auth`, `book_isexchange`, `book_press`,  `book_stock`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    //促销商品查询
    public static final String fingbook_discount = "SELECT * FROM bookinfo WHERE book_discount != 1";

    //审核状态的查询
    public static final String findbybook_status = "SELECT * FROM bookinfo WHERE book_status !=0";
    //点击审核查询商品详情
    public static final String shenhechaxun = "SELECT * FROM bookinfo WHERE book_id=? ";
    //审核修改
    public static final String shenhexiugai ="update  bookinfo set book_status=? where book_id=? ";
    //添加一本书籍
    public static final String insertBookInfo="insert into bookinfo(book_name,book_price,book_discount,book_discountprice,book_details,book_status,book_typeid,book_fitclass,book_auth,userid,book_isexchange,book_press,book_stock) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";

    public static final String findid = "SELECT book_id ,book_name,book_price,book_discountprice,book_details,book_status,book_typeid,book_fitclass,book_auth,book_press,book_date FROM bookinfo where book_id = ?";
}
