<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="名榜,wangid">
    <title>添加</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/children.css">

    <!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- layui css -->
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <!-- layui js -->
    <script src="layui/layui.js"></script>
</head>


<body style="background: #fff;">
<div class="tianjia_xx">

        <table class="if_tianjiatext layui-table" lay-size="lg">

            <tbody>
            <tr>
                <td  class="td_1">商品编号</td>
                <td>${book.book_id}</td>
            </tr>
            <tr>
                <td  class="td_1">商品姓名</td>
                <td>${book.book_name}</td>
            </tr>
            <tr>
                <td  class="td_1">商品价格</td>
                <td>${book.book_price}</td>
            </tr>
            <tr>
                <td  class="td_1">折扣等级</td>
                <td>${book.book_discount}</td>
            </tr>
            <tr>
                <td  class="td_1">折扣价</td>
                <td>${book.book_discountprice}</td>
            </tr>
            <tr>
                <td  class="td_1">图片</td>
                <td> ${book.book_img}</td>
            </tr>
            <tr>
                <td  class="td_1">商品详情</td>
                <td> ${book.book_details}</td>
            </tr>
            <tr>
                <td  class="td_1">审核状态</td>
                <c:if test="${book.book_status==0}">
                    <td>待审核</td>
                </c:if>
                <c:if test="${book.book_status==1}">
                    <td>已审核</td>
                </c:if>

            </tr>


            <tr>
                <td  class="td_1">作者</td>
                <td> ${book.book_auth}</td>
            </tr>
            <tr>
                <td  class="td_1">上传用户</td>
                <td> ${book.userid}</td>
            </tr>

            <tr>
                <td  class="td_1">出版社</td>
                <td> ${book.book_press}</td>
            </tr>

            <tr>
                <td  class="td_1">库存</td>
                <td> ${book.book_stock}</td>
            </tr>
            <tr class="tianjie_button">
                <td colspan="2" style="border-right:1px solid #e6e6e6;">
                    <form action="ShenhezhongServlet?id=${book.book_id}" method="post">
                      审核：<select name="shenhe" style="border: 1px solid black" >
                            <option value="0">待审核</option> 　　
                            <option value="1">已通过</option> 　　　
                        　　</select>
                    <button type="submit">审核</button>
                    </form>

                </td>
            </tr>
            </tbody>

        </table>

</div>
<script type="text/javascript">

</script>
</body>

</html>
