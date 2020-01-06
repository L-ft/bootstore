<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/31 0031
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            margin: 0 auto;
        }
        td{
            height: 40px;
            line-height: 40px;
        }
    </style>
</head>
<body>
<table >
    <tr>
        <td style="color: #2272c8;text-align: right" >发件人：</td>
        <td>商城系统</td>
    </tr>
    <tr>
        <td style="color: #2272c8;text-align: right" >时间：</td>
        <td>${order.order_date}</td>
    </tr>
    <tr>
        <td style="color: #2272c8;text-align: right" >订单编号：</td>
        <td>${order.order_number}</td>
    </tr>
    <tr>
        <td style="color: #2272c8;text-align: right" >信息详情：</td>
        <td >尊敬的用户你好，您的商品:<span style="color: red">${order.books.book_name}</span>退货成功，共计${order.orderDetails.book_number}件，
            商品实付款为 <span style="color: red">${order.books.book_discountprice*order.orderDetails.book_number}元</span>，已原支付返回 </td>
    </tr>
    <tr >
        <td style="text-align: center" colspan="2"><a href="${pageContext.request.contextPath}/XiTongXinXiServlet?ye=${ye}">返回</a></td>
    </tr>

</table>


</body>
</html>
