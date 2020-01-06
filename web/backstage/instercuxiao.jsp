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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/children.css">

    <!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- layui css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/backstage/js/jquery-1.11.0.min.js"></script>
    <!-- layui js -->
    <script src="${pageContext.request.contextPath}/backstage/layui/layui.js"></script>
</head>


<body style="background: #fff;">
<div class="tianjia_xx">

    <table class="if_tianjiatext layui-table" lay-size="lg">

        <tbody>
        <tr>
            <td  class="td_1">商品编号</td>
            <td>${bookinfo.book_id}</td>
        </tr>
        <tr>
            <td  class="td_1">商品姓名</td>
            <td>${bookinfo.book_name}</td>
        </tr>
        <tr>
            <td  class="td_1">商品价格</td>
            <td>${bookinfo.book_price}</td>
        </tr>

        <tr>
            <td  class="td_1">折扣价</td>
            <td>${bookinfo.book_discountprice}</td>
        </tr>

        <tr>
            <td  class="td_1">商品详情</td>
            <td>${bookinfo.book_details}</td>
        </tr>
        <tr>
            <td  class="td_1">审核状态</td>
            <td>${bookinfo.book_status}</td>
        </tr>
        <tr>
            <td  class="td_1">商品类型</td>
            <td>${bookinfo.book_typeid}></td>
        </tr>
        <tr>
            <td  class="td_1">适合班级</td>
            <td>${bookinfo.book_fitclass}</td>
        </tr>
        <tr>
            <td  class="td_1">作者</td>
            <td>${bookinfo.book_auth}</td>
        </tr>


        <tr>
            <td  class="td_1">出版社</td>
            <td>${bookinfo.book_press}</td>
        </tr>

        <tr style="border: 1px solid #CCCCCC">
            <td style="text-align: center"><a href="${pageContext.request.contextPath}/FindBookdiscount"><input type="button" value="返回"></a></td>
        </tr>
        </tbody>

    </table>

</div>
<script type="text/javascript">

</script>
</body>

</html>