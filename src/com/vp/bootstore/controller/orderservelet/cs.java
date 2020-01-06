package com.vp.bootstore.controller.orderservelet;

import com.vp.bootstore.dao.impl.IOrderDaoImpl;
import com.vp.bootstore.pojo.Order;

import java.util.List;

public class cs {
    public static void main(String[] args) {


            // System.out.println(list.get(i).getBooktype_name());
//            if (a.getBooktype_name()!=b.getBooktype_name()){
//                System.out.println(a.getBooktype_name()+":");
//            }


        List<Order> orders=new IOrderDaoImpl().lianhehuangou(new String[]{"%%","200","1000","%%","2"},new int[]{0,3});
        System.out.println(orders==null);
        if (orders!=null){
            System.out.println(orders.get(0).getOrder_number());


        }


    }
}
