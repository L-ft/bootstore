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
    <form action="${pageContext.request.contextPath}/InsterCuxiao" method="post">
        <table class="if_tianjiatext layui-table" lay-size="lg">
        <tbody>
            <tr>
                <td  class="td_1">编号</td>
                <td><input type="text" placeholder="1" name="comment_id"></td>
            </tr>
            <tr>
                <td  class="td_1">会员id</td>
                <td><input type="text" placeholder="1" name="book_id"></td>
            </tr>
            <tr>
                <td  class="td_1">商品编号</td>
                <td><input type="text" placeholder="10" name="user_id"></td>
            </tr>
            <tr>
                <td  class="td_1">评论内容</td>
                <td><input type="text" placeholder="很好哟" name="comment_content"></td>
            </tr>
            <tr class="tianjie_button">
                <td colspan="2" style="border-right:1px solid #e6e6e6;height: 50px">
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
