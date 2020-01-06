package com.vp.bootstore.constans;

/**
 * @Author: duYang
 * @Date: 2019/12/23 14:01
 * @Version: 1.0
 */
public class OrderSql {
    //后台   商品订单管理sql语句
    //子查询订单信息
    public static final String selectsy="select  o.order_id,o.order_number,o.user_id,o.order_date,o.order_price,o.order_status from `order` o,orderdetail d,bookinfo b where o.order_id=d.order_id and d.book_id=b.book_id  limit ?,?";
    //查询商品订单的配送地址
    public static final String selectaddress="select r.receiving_address  from `order` o,receiving r,orderdetail d where o.receiving_id=r.receiving_id and o.order_id=d.order_id limit ?,?";
    //查询商品名称
    public static final String selectbookname="select b.book_name from `order` o,orderdetail d,bookinfo b where o.order_id=d.order_id and d.book_id=b.book_id limit ?,?";
    //查询总共有几条商品订单
    public static final String selectOrdercount="select count(o.order_number) from `order` o,orderdetail d,bookinfo b where o.order_id=d.order_id and d.book_id=b.book_id  ";
    //删除订单
    public static final String deleteOrders="delete from `order` where order_id=? ";
    public static final String deleteOrderstail="delete from orderdetail  where order_id=? ";
    //订单查看详情
    public static final String dingdanxiangq="select o.order_number,o.user_id,r.receiving_address,o.order_date ,b.book_name,b.book_discountprice,o.order_price,o.order_status   from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id  and o.order_number=? and b.book_name=? ";

    //联合分页查询
    public static final String lianheselectO="select  o.order_id,o.order_number,o.user_id,r.receiving_address,o.order_date,b.book_name,o.order_price,o.order_status from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id and o.order_number like ? and r.receiving_address  like  ? and o.order_status like ? and o.order_date>? and o.order_date<? limit ?,?";
    public static final String lianhecount="select  count(o.order_number) from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id and o.order_number like ? and r.receiving_address  like  ? and o.order_status like ? and o.order_date>? and o.order_date<?";


    //销售额查询
    public static final String xiaoshoue="select  o.order_id,b.book_press,o.order_number,b.book_name,d.book_number,o.order_price,o.order_date from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id and o.order_status>=1  limit ?,? ";
    public static final String xiaoshouecount="select  count(o.order_number) from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id and o.order_status>=1";
    //多条件查询
    public static final String xiaosoudtjian="select  o.order_id,b.book_press,o.order_number,b.book_name,d.book_number,o.order_price,o.order_date from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id and o.order_status>0 and b.book_name like ? and o.order_date>? and o.order_date<? limit ?,? ";
    public static final String xiaosoudtjiancount="select  count(d.book_number) from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id and o.order_status>0 and b.book_name like ? and o.order_date>? and o.order_date<? ";
    public static final String xiaosoudtxiangq="select  o.order_id,b.book_press,o.order_number,b.book_name,b.book_auth,d.book_number,b.book_price,b.book_discountprice,o.order_date from `order` o,orderdetail d,bookinfo b,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and o.receiving_id=r.receiving_id and o.order_status>0 and o.order_id=? and b.book_name=?";





//积分来源查询所有
    public static final String jifenselect="select  o.user_id,o.order_number,b.book_discountprice,b.book_name,b.book_img,t.booktype_name,t.booktype_detailname,b.book_details     from `order` o,orderdetail d,bookinfo b,booktype t where o.order_id=d.order_id and d.book_id=b.book_id and t.booktype_id=b.book_typeid  and o.order_status>0 limit ?,? ";
    public static final String jifenselectcount="select  count(o.order_id)     from `order` o,orderdetail d where o.order_id=d.order_id  and o.order_status>0";

    //联合查询积分
    public static final String jifenlianheselect="select o.user_id,o.order_number,b.book_discountprice,b.book_name,b.book_img,t.booktype_name,t.booktype_detailname,b.book_details  from `order` o,orderdetail d,bookinfo b,booktype t where o.order_id=d.order_id and d.book_id=b.book_id and t.booktype_id=b.book_typeid  and o.order_status>0 and o.user_id like ? and o.order_number like ? and b.book_discountprice>? and b.book_discountprice<=? and b.book_name like ? and t.booktype_name  like ? and t.booktype_detailname like ? limit ?,? ";
    public static final String jifenlianhecount="select  count(o.user_id)     from `order` o,orderdetail d,bookinfo b,booktype t where o.order_id=d.order_id and d.book_id=b.book_id and t.booktype_id=b.book_typeid  and o.order_status>0  and o.user_id like ? and o.order_number like ? and b.book_discountprice>? and b.book_discountprice<=? and b.book_name like ? and t.booktype_name  like ? and t.booktype_detailname like ? ";

    //查询积分换购记录
    public static final String huangou="select  o.user_id,o.order_number,o.integral,b.book_name,o.order_date,o.order_status,r.receiving_address     from `order` o,orderdetail d,bookinfo b,booktype t,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and t.booktype_id=b.book_typeid and r.receiving_id=o.receiving_id and o.order_status>0 and o.integral>0  limit ?,? ";
    public static final String huangoucount="select    count(o.user_id)     from `order` o,orderdetail d,bookinfo b,booktype t,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and t.booktype_id=b.book_typeid and r.receiving_id=o.receiving_id and o.order_status>0 and o.integral>0";
    //联合查询积分换购记录
    public static final String huangoulianhe="select  o.user_id,o.order_number,o.integral,book.book_name,o.order_date,o.order_status,re.receiving_address  from `order` o,orderdetail od,receiving re,bookinfo book where o.order_id=od.order_id and od.book_id=book.book_id and o.receiving_id=re.receiving_id and o.order_number like ? and o.integral>? and  o.integral<=? and book.book_name like ? and o.order_status like ?  limit ?,? ";
    public static final String huangoulianhecount="select  count(o.user_id) from `order` o,orderdetail od,receiving re,bookinfo book where o.order_id=od.order_id and od.book_id=book.book_id and o.receiving_id=re.receiving_id and o.order_number like ? and o.integral>? and o.integral<=? and book.book_name like ? and o.order_status like ? ";
    //查看详情
    //积分换购
    public static final String huangouchakan=" select  o.user_id,o.order_number,o.integral,b.book_name,b.book_auth,b.book_press,b.book_price,b.book_discountprice,o.order_date,o.order_status,r.receiving_address     from `order` o,orderdetail d,bookinfo b,booktype t,receiving r where o.order_id=d.order_id and d.book_id=b.book_id and t.booktype_id=b.book_typeid and r.receiving_id=o.receiving_id and o.order_status>0 and o.order_number=? and b.book_name=? ";
   //积分来源
    public static final String jifenchakan=" select  o.user_id,o.order_number,b.book_discountprice,b.book_name,b.book_img,t.booktype_name,t.booktype_detailname,b.book_details     from `order` o,orderdetail d,bookinfo b,booktype t where o.order_id=d.order_id and d.book_id=b.book_id and t.booktype_id=b.book_typeid  and o.order_status>0 and o.order_number=? and b.book_name=? ";

}
