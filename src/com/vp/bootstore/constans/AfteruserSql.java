package com.vp.bootstore.constans;

public class AfteruserSql {

    //登录
    public static final String login = "SELECT * FROM afteruser WHERE arname = ? AND arpassword = ?";

    //查询所有
    public static final String findall = "SELECT arid,arname,arpassword,bumen,quanxian,danwei,address,phone,email,qq FROM afteruser";

    //删除
    public static final String delete = "DELETE FROM afteruser WHERE arid = ?";

    //模糊查询
    public static final String findlike = "SELECT arid,arname,arpassword,bumen,quanxian,danwei,address,phone,email,qq FROM afteruser WHERE arname LIKE ? AND bumen LIKE ?";

    //查看
    public static final String findbyarname = "SELECT arid,arname,arpassword,bumen,quanxian,danwei,address,phone,email,qq FROM afteruser WHERE arid = ?";
}
