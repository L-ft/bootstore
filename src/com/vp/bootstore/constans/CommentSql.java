package com.vp.bookstore.constans;

/**
 * @Author: duYang
 * @Date: 2019/12/23 14:00
 * @Version: 1.0
 */
public class CommentSql {

    //查询所有
    public static final String findall = "SELECT c.comment_id,c.book_id,c.user_id,c.comment_content,c.comment_date,b.book_name FROM `comment` c ,bookinfo b WHERE c.book_id = b.book_id";

    //删除
    public static final String delete = "DELETE FROM `comment` WHERE comment_id = ?";

    //添加
    public static final String inster = "INSERT INTO `bookstore`.`comment` (`comment_id`, `book_id`, `user_id`, `comment_content`) VALUES (?, ?, ?,?)";

    //模糊查询
    public static final String fingbylike = "SELECT c.comment_id,c.book_id,c.user_id,c.comment_content,c.comment_date,b.book_name FROM `comment` c ,bookinfo b  WHERE c.comment_content LIKE ? AND c.book_id = b.book_id";
}
