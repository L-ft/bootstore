package com.vp.bootstore.dao;

import com.vp.bookstore.pojo.Afteruser;

import java.util.List;

public interface AfteruserDao {

    /**
     * 功能 : 登录
     * @return
     */
    public Afteruser login(Afteruser afteruser);

    /**
     * 功能 查询所有
     * 传入 null
     * return list afteruser
     */
    List<Afteruser> findall();

    /**
     * 功能 删除
     * 传入 arid
     * return int
     */
    int delete(int arid);

    /**
     * 功能 模糊查询
     * 传入 afteruser
     * return list afteruser
     */
    List<Afteruser> findlike(Afteruser afteruser);

    /**
     * 功能 查看
     * 传入 arid
     * return afteruser
     */
    Afteruser findbyarid(int arid);
}
