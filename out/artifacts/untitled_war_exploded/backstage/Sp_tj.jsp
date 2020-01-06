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
                    <div >订单编号:<span>${order.order_number}</span></div>

                </li>
                <li>
                    <div >出版社: <span>${order.books.book_press}</span></div>

                </li>
                <li>
                    <div >书名: <span>${order.books.book_name}</span></div>

                </li>
                <li>
                    <div >作者:<span>${order.books.book_auth}</span></div>


                </li>
                <li>
                    <div >销售数量:<span>${order.orderDetails.book_number}</span</div>


                </li>
                <li>
                    <div >单价: <span>${order.books.book_price}</span></div>

                </li>
                <c:if test="${order.books.book_price!=null}">
                <li>
                    <div >折扣后的价格:<span>${order.books.book_discountprice}</span></div>

                </li>
                </c:if>
                <li>
                    <div >销售金额:

                        <c:if test="${order.books.book_discountprice!=null}">
                            <span>${order.books.book_discountprice*order.orderDetails.book_number}</span>
                        </c:if>
                        <c:if test="${order.books.book_discountprice==null}">
                            <span>${order.books.book_price*order.orderDetails.book_number}</span>
                        </c:if>
                  </div>
                </li>
                <li>
                    <div >销售时间:<span>${order.order_date}</span></div>

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
    

    
</body>

</html>
<script>
    function fanhui(){
        location="${pageContext.request.contextPath}/OrdersServlet?id=${cid}&ye=${ye}";
    }

        layui.use(['form', 'layedit', 'laydate'], function(){
          var form = layui.form
          ,layer = layui.layer
          ,layedit = layui.layedit
          ,laydate = layui.laydate;
        });
        </script>
