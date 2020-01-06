package com.vp.bootstore.pojo;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:40
 * @Version: 1.0
 */

import lombok.Data;

import java.sql.Timestamp;

/**
 * 订单表
 */
@Data
public class Order implements java.io.Serializable{
    private static final long serialVersionUID = 5659758877323700987L;

    /** orderid */
    private Integer order_id;

    /** 订单编号ordernumber */
    private String order_number;

    /** 用户id */
    private Integer user_id;

    /** 订单总价 */
    private Double order_price;

    /** 订单状态（0下单没付款，1下单已付款，2付款未发货，3付款已经发货等等） */
    private int order_status;

    /** 订单时间 */
    private Timestamp order_date;

    /** 订单总价 */
    private Integer receiving_id;

    private BookInfo books;
    private Receiving reces;
    private OrderDetail orderDetails;
    private BookType bt;
    private int jifen;

    private int integral;

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getJifen() {
        return jifen;
    }

    public void setJifen(int jifen) {
        this.jifen = jifen;
    }

    public BookType getBt() {
        return bt;
    }

    public void setBt(BookType bt) {
        this.bt = bt;
    }

    public OrderDetail getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetail orderDetails) {
        this.orderDetails = orderDetails;
    }

    public BookInfo getBooks() {
        return books;
    }

    public void setBooks(BookInfo books) {
        this.books = books;
    }

    public Receiving getReces() {
        return reces;
    }

    public void setReces(Receiving reces) {
        this.reces = reces;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public Integer getReceiving_id() {
        return receiving_id;
    }

    public void setReceiving_id(Integer receiving_id) {
        this.receiving_id = receiving_id;
    }
}
