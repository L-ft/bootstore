package com.vp.bootstore.pojo;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:42
 * @Version: 1.0
 */

import lombok.Data;

/**
 * 收货地址表
 */
@Data
public class Receiving implements java.io.Serializable{
    private static final long serialVersionUID = -3381312015282731585L;


    /** 收货地址ID */
    private Integer receiving_id;

    /** 地区 */
    private String receiving_region;

    /** 地址 */
    private String receiving_address;

    /** 邮政编码 */
    private String postalcode;

    /** 收货人姓名 */
    private String receiving_name;

    /** 收货人手机号 */

    private String receiving_phone;




    /** 关联用户ID */
    private Integer user_id;


    public Receiving(Integer receiving_id, String receiving_region, String receiving_address, String postalcode, String receiving_name, String receiving_phone, Integer user_id) {
        this.receiving_id = receiving_id;
        this.receiving_region = receiving_region;
        this.receiving_address = receiving_address;
        this.postalcode = postalcode;
        this.receiving_name = receiving_name;
        this.receiving_phone = receiving_phone;
        this.user_id = user_id;
    }

    public Receiving() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getReceiving_id() {
        return receiving_id;
    }

    public void setReceiving_id(Integer receiving_id) {
        this.receiving_id = receiving_id;
    }

    public String getReceiving_region() {
        return receiving_region;
    }

    public void setReceiving_region(String receiving_region) {
        this.receiving_region = receiving_region;
    }

    public String getReceiving_address() {
        return receiving_address;
    }

    public void setReceiving_address(String receiving_address) {
        this.receiving_address = receiving_address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getReceiving_name() {
        return receiving_name;
    }

    public void setReceiving_name(String receiving_name) {
        this.receiving_name = receiving_name;
    }

    public String getReceiving_phone() {
        return receiving_phone;
    }

    public void setReceiving_phone(String receiving_phone) {
        this.receiving_phone = receiving_phone;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
