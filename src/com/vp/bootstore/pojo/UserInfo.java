package com.vp.bootstore.pojo;

/**
 * @Author: duYang
 * @Date: 2019/12/23 10:24
 * @Version: 1.0
 */

import lombok.Data;

/**
 * 用户信息表
 */
@Data
public class UserInfo implements java.io.Serializable{
    private static final long serialVersionUID = -7592885055310803868L;
    /** userId */
    private Integer user_id;

    /** 用户昵称 */
    private String user_nickname;

    /** 手机号 */
    private String user_phone;

    /** 邮箱 */
    private String user_email;

    /** 用户密码 */
    private String user_password;

    /** 年龄 */
    private Integer user_age;

    /** qq账号 */
    private String user_qq;

    /** 学校 */
    private String user_school;

    /** 学校班级 */
    private String user_school_class;

    /** 地区 */
    private String user_region;

    /** 地址 */
    private String user_address;

    /** 用户图片 */
    private String user_img;

    /** 用户身份 */
    private String user_identity;

    /** 真实姓名 */
    private String user_realname;

    /** 性别 */
    private Integer user_gender;

    /** 用户爱好 */
    private String user_hobby;

    /** 用户介绍 */
    private String user_introduce;

    /** 用户积分 */
    private Integer user_integral;

    public UserInfo() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_school() {
        return user_school;
    }

    public void setUser_school(String user_school) {
        this.user_school = user_school;
    }

    public String getUser_school_class() {
        return user_school_class;
    }

    public void setUser_school_class(String user_school_class) {
        this.user_school_class = user_school_class;
    }

    public String getUser_region() {
        return user_region;
    }

    public void setUser_region(String user_region) {
        this.user_region = user_region;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_identity() {
        return user_identity;
    }

    public void setUser_identity(String user_identity) {
        this.user_identity = user_identity;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public Integer getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(Integer user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_hobby() {
        return user_hobby;
    }

    public void setUser_hobby(String user_hobby) {
        this.user_hobby = user_hobby;
    }

    public String getUser_introduce() {
        return user_introduce;
    }

    public void setUser_introduce(String user_introduce) {
        this.user_introduce = user_introduce;
    }

    public Integer getUser_integral() {
        return user_integral;
    }

    public void setUser_integral(Integer user_integral) {
        this.user_integral = user_integral;
    }
}
