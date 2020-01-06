<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>WangID办公管理系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/children.css">

    <!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- layui css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/backstage/js/jquery-1.11.0.min.js"></script>
    
</head>

<body>
    <div class="wangid_conbox">
        <!-- 当前位置 -->
        <div class="zy_weizhi bord_b">
            <i class="fa fa-home fa-3x"></i>
            <a>首页</a>
            <a>客户保护</a>
            <span>添加保护系统</span>
        </div>
        <!-- 内容 -->    

        
        <div class="kehubh_tj_k">

            <ul>
                <li>
                    <div>会员编号:<span>${order.user_id}</span></div>
                </li>
                <li>
                    <div>订单编号:<span>${order.order_number}</span></div>
                </li>

                <li>
                    <div>积分:<span>${order.jifen}</span></div>
                </li>
                <li>
                    <div>商品名称:<span>${order.books.book_name}</span></div>
                </li>
                <li>
                    <div>商品图片:<img src="${order.books.book_img}" ></div>
                </li>
                <li>
                    <div>商品类型:<span>${order.bt.booktype_name}/${order.bt.booktype_detailname}</span></div>
                </li>
                <li>
                    <div>商品描述:<span>${order.books.book_details}</span></div>
                </li>

                <li>
                    <div class="left"> &nbsp;</div>
                    <div class="right">
                        <button class="button_qr" onclick="fanhui()">返回</button>
                    </div>
                </li>
            </ul>

        </div>
    </div>   
    
	<!-- houl --> 
	<!-- 结束 -->
    <!-- layui js -->

    
</body>

</html>
<script>
    function fanhui(){
        location="${pageContext.request.contextPath}/JifenduihuanServlet?id=${id}&ye=${ye}";
    }


        </script>
