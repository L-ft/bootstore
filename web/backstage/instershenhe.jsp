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
    <form action="${pageContext.request.contextPath}/InsterShenhe" method="post">
        <table class="if_tianjiatext layui-table" lay-size="lg">

            <tbody>
            <tr>
                <td  class="td_1">商品编号</td>
                <td><input type="text" placeholder="1" name="book_id"></td>
            </tr>
            <tr>
                <td  class="td_1">商品姓名</td>
                <td><input type="text" placeholder="十万个为什么" name="book_name"></td>
            </tr>
            <tr>
                <td  class="td_1">商品价格</td>
                <td><input type="text" placeholder="123" name="book_price"></td>
            </tr>
            <tr>
                <td  class="td_1">折扣等级</td>
                <td><input type="text" placeholder="0.8" name="book_discount"></td>
            </tr>
            <tr>
                <td  class="td_1">折扣价</td>
                <td><input type="text" placeholder="89" name="book_discountprice"></td>
            </tr>
            <tr>
                <td  class="td_1">图片</td>
                <td> <input type="file" placeholder="a.jpg" name="book_img"></td>
            </tr>
            <tr>
                <td  class="td_1">商品详情</td>
                <td> <input type="text" placeholder="十万个为什么" name="book_details"></td>
            </tr>
            <tr>
                <td  class="td_1">审核状态</td>
                <td> <input type="text" placeholder="1" name="book_status"></td>
            </tr>
            <tr>
                <td  class="td_1">商品类型</td>
                <td> <input type="text" placeholder="教育" name="book_typeid"></td>
            </tr>
            <tr>
                <td  class="td_1">适合班级</td>
                <td> <input type="text" placeholder="1" name="book_fitclass"></td>
            </tr>
            <tr>
                <td  class="td_1">作者</td>
                <td> <input type="text" placeholder="张三" name="book_auth"></td>
            </tr>
            <tr>
                <td  class="td_1">上传用户</td>
                <td> <input type="text" placeholder="1" name="userid"></td>
            </tr>
            <tr>
                <td  class="td_1">是否可以兑换</td>
                <td> <input type="text" placeholder="1" name="book_isexchange"></td>
            </tr>
            <tr>
                <td  class="td_1">出版社</td>
                <td> <input type="text" placeholder="华中出版社" name="book_press"></td>
            </tr>
            <tr>
                <td  class="td_1">收藏数量</td>
                <td> <input type="text" placeholder="20" name="book_collection"></td>
            </tr>
            <tr>
                <td  class="td_1">售出数量</td>
                <td> <input type="text" placeholder="2" name="book_sell"></td>
            </tr>
            <tr>
                <td  class="td_1">库存</td>
                <td> <input type="text" placeholder="200" name="bookStock"></td>
            </tr>
            <tr class="tianjie_button">
                <td colspan="2" style="border-right:1px solid #e6e6e6;">
                    <input style="height: 50px" type="submit" value="提交">
                </td>
            </tr>
            </tbody>

        </table>
    </form>
</div>
<script type="text/javascript">

</script>
</body>

</html>
