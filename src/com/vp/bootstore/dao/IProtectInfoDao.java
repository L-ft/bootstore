package com.vp.bootstore.dao;

/**
 * @Author: duYang
 * @Date: 2019/12/23 10:59
 * @Version: 1.0
 */


import com.vp.bootstore.pojo.Protect;

import java.util.List;

/**
 * 密保表接口
 */
public interface IProtectInfoDao {
    /**
     * 功能：返回用户的全部密保问题
     * 传入：user_id
     * return list protect
     */
    List<Protect> findByProtectId(int id);

    /**
     * 功能：判断用户输入的密保答案是否正确
     * 传入：user_id,protect_id,protect_answer
     * return boolean
     */
    boolean judgeProtectAnswer(Protect protect);
}
