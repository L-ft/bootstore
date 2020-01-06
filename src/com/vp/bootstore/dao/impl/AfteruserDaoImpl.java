package com.vp.bootstore.dao.impl;


import com.vp.bookstore.pojo.Afteruser;

import com.vp.bootstore.constans.AfteruserSql;
import com.vp.bootstore.dao.AfteruserDao;
import com.vp.bootstore.util.DruidPollUtil;
import com.vp.bootstore.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AfteruserDaoImpl implements AfteruserDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Afteruser afteruser;
    private List<Afteruser> afterusers;

    //登录
    @Override
    public Afteruser login(Afteruser afteruser) {
        return JdbcUtil.executeQuery(AfteruserSql.login,new Object[]{afteruser.getArname(),afteruser.getArpassword()},Afteruser.class);
    }

    @Override
    public List<Afteruser> findall() {

        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(AfteruserSql.findall);
            rs = ps.executeQuery();
            afterusers = new ArrayList<>();
            while (rs.next()){
                afteruser = new Afteruser();
                afteruser.setArid(rs.getInt("arid"));
                afteruser.setArname(rs.getString("arname"));
                afteruser.setArpassword(rs.getString("arpassword"));
                afteruser.setBumen(rs.getString("bumen"));
                afteruser.setQuanxian(rs.getString("quanxian"));
                afteruser.setDanwei(rs.getString("danwei"));
                afteruser.setAddress(rs.getString("address"));
                afteruser.setPhone(rs.getString("phone"));
                afteruser.setEmail(rs.getString("email"));
                afteruser.setQq(rs.getString("qq"));

                afterusers.add(afteruser);
            }
            return afterusers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int arid) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(AfteruserSql.delete);
            ps.setInt(1,arid);

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Afteruser> findlike(Afteruser afteruser) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(AfteruserSql.findlike);
            ps.setString(1,"%"+afteruser.getArname()+"%");
            ps.setString(2,"%"+afteruser.getBumen()+"%");

            rs = ps.executeQuery();
            afterusers = new ArrayList<>();
            while (rs.next()){
                afteruser = new Afteruser();
                afteruser.setArid(rs.getInt("arid"));
                afteruser.setArname(rs.getString("arname"));
                afteruser.setArpassword(rs.getString("arpassword"));
                afteruser.setBumen(rs.getString("bumen"));
                afteruser.setQuanxian(rs.getString("quanxian"));
                afteruser.setDanwei(rs.getString("danwei"));
                afteruser.setAddress(rs.getString("address"));
                afteruser.setPhone(rs.getString("phone"));
                afteruser.setEmail(rs.getString("email"));
                afteruser.setQq(rs.getString("qq"));

                afterusers.add(afteruser);
            }
            return afterusers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Afteruser findbyarid(int arid) {
        try {
            conn= DruidPollUtil.getConnection();
            ps = conn.prepareStatement(AfteruserSql.findbyarname);
            ps.setInt(1,arid);
            rs = ps.executeQuery();

            while (rs.next()){

                afteruser = new Afteruser();
                afteruser.setArid(rs.getInt("arid"));
                afteruser.setArname(rs.getString("arname"));
                afteruser.setArpassword(rs.getString("arpassword"));
                afteruser.setBumen(rs.getString("bumen"));
                afteruser.setQuanxian(rs.getString("quanxian"));
                afteruser.setDanwei(rs.getString("danwei"));
                afteruser.setAddress(rs.getString("address"));
                afteruser.setPhone(rs.getString("phone"));
                afteruser.setEmail(rs.getString("email"));
                afteruser.setQq(rs.getString("qq"));


            }
            return afteruser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
