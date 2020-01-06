package com.vp.bootstore.dao;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:40
 * @Version: 1.0
 */


import com.vp.bootstore.pojo.BookInfo;
import com.vp.bootstore.pojo.Order;
import com.vp.bootstore.pojo.Receiving;

import java.sql.SQLException;
import java.util.List;

/**
 * 订单表接口
 */
public interface IOrderDao {
    //分页查询
    List<Order> selectsy(int ye, int hang);
    List<Receiving> selectAddress(int ye, int hang);
    List<BookInfo>  selectBookname(int ye, int hang);
    //查询总页数
    int selectCoumt(int hang);

    //删除order和orderdetail
    int deleteorder(int id);
    int orderdetail(int id);

    //联合查询
    List<Order> lianheselect(String[] tj, int[] fy) throws SQLException;
    public int lhselectCount(Object[] o, int h);
    //订单查看
    Order dingdanchak(String id, String book);

    //销售额查询
    List<Order> xiaoshou(int ye, int hang);
    int xiaoshouCoumt(int hang);
    //销售多条件查询
    List<Order> xiaoshoudtj(String[] tj, int[] fy);
    //总页数
    int xiaoshoudtjcount(Object[] tj, int hang);
    //查看
    Order xiaosouxiangq(int id, String book);

    //积分来源查询
    List<Order> jifenlaiyuan(int kai, int jie);
    int jifenlaiyuancount(int hang);

    //积分来源联合查询
    List<Order> jifenlianhe(String[] index, int[] fy);
    int jifenlianhecount(String[] index, int hang);

    //积分换购记录
    List<Order> huangou(int a, int b);
    int huangoucount(int hang);

    //联合查询积分换购记录
    List<Order> lianhehuangou(String[] index, int[] fy);
    int lianhehuangoucount(String[] index, int hang);
    //查看
    Order huangouchakan(String bh, String name);
    Order jifenchakan(String bh, String name);





    //  //查询所有已付款已发货和已收货商品
    List<Order> shenqinagtuihuo(int qi,int hang);
    int tuihuocount(int hang);
    //退货将会扣除积分
    int kouchujifen(int jf,int id);
    //根据订单编号退货
    int tuihuo(String time,String bh);

    ////系统信息退货成功
    List<Order> xitongxinxi(int qi,int hang);
    int xitongxinxicount(int hang);
    //查看详情
    Order xitongxiangqing(String number,String name);
}
