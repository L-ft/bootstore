package com.vp.bootstore.dao;

/**
 * @Author: duYang
 * @Date: 2019/12/23 13:24
 * @Version: 1.0
 */


import com.vp.bootstore.pojo.BookInfo;

import java.util.List;

/**
 * 书籍表接口
 */
public interface IBookInfoDao {
    /**
     * 功能：获得书籍的信息
     * 传入：book_id
     * return BookInfo
     */
    BookInfo findByBookId(int id);

    /**
     * 功能：返回热销排行榜书籍信息
     * 传入：size
     * return list BookInfo
     */
    List<BookInfo> findHeatRanking(int size);

    /**
     * 功能：返回最新上架书籍的信息
     * 传入：size
     * return list BookInfo
     */
    List<BookInfo> findNewBookRanking(int size);

    /**
     * 功能：返回折扣最低书籍的信息
     * 传入：size
     * return list BookInfo
     */
    List<BookInfo> findDisCountBookRanking(int size);

    /**
     * 查询所有的书籍
     * 传入：null
     * return list BookInfo
     */
    List<BookInfo> findall();

    /**
     * 功能：删除书籍
     * 传入：book_id
     * return 0
     */
    int delete(int book_id);

    /**
     * 功能：模糊查询
     * 传入 bookInfo
     *return list bookinfo
     */
    List<BookInfo> findLike(BookInfo bookInfo);
    List<BookInfo> shenhefindLike(BookInfo bookInfo);
    /**
     * 功能 ：添加
     * 传入 bookInfo
     * return 0
     */
    int inster(BookInfo bookInfo);

    /**
     * 功能 促销商品查询
     * 传入 null
     * return list BookInfo
     */
    List<BookInfo> findbybook_discount();

    /**
     * 功能 审核状态的查询
     * 传入 null
     * return list BookInfo
     */
    List<BookInfo> findbybook_status();



    BookInfo shenhechaxun(int id);

    int shenhetg(int id,int sid);

    /**
     * 功能：添加一本待审批的书籍
     * 传入：BookInfo
     * return Boolean
     */
    boolean insertBookInfo(BookInfo bookInfo,Integer userid);


    BookInfo findid(int book_id);
}
