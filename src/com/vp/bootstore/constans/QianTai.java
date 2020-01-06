package com.vp.bootstore.constans;

public class QianTai {
    //查询所有已付款已发货和已收货商品
    public static final String shenqinagtuihuo="select o.order_number,b.book_img,b.book_details,o.order_status,b.book_discountprice,o.order_price  from `order` o,orderdetail d,bookinfo b where o.order_id=d.order_id and d.book_id=b.book_id and o.order_status>=1 and o.order_status<=3 limit ?,?  ";
    //退货将会扣除积分
    public static final String kouchujifen="update  userinfo set user_integral=user_integral-?  where user_id=? ";
    //根据订单编号退货
    public static final String tuihuo="update  `order` set order_status=4, order_date=?  where order_number=? ";
    //总页数
    public static final String count="select count(o.order_number) from `order` o,orderdetail d,bookinfo b  where o.order_id=d.order_id and d.book_id=b.book_id  and o.order_status>=1 and o.order_status<=3 ";

    //系统信息退货成功
    public static final String xitongxinxi="select o.order_number,b.book_name,o.order_date  from `order` o,orderdetail d,bookinfo b where o.order_id=d.order_id and d.book_id=b.book_id  and o.order_status=4 limit ?,? ";
    public static final String xitongxinxicount="select count(o.order_number)  from `order` o,orderdetail d,bookinfo b where o.order_id=d.order_id and d.book_id=b.book_id  and o.order_status=4 ";
    //系统信息详情
    public static final String xitongxinxixiangq="select o.order_number,b.book_name,o.order_date,b.book_discountprice,d.book_number,o.order_price  from `order` o,orderdetail d,bookinfo b where o.order_id=d.order_id and d.book_id=b.book_id  and o.order_status=4 and o.order_number=?  and b.book_name=? ";

}
