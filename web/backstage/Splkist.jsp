<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/layui/css/layui.css" media="all">
	<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/js/jquery-1.11.0.min.js"></script>
	<!-- layui js -->
	<script src="${pageContext.request.contextPath}/backstage/layui/layui.js"></script>
</head>

<body>
<div class="wangid_conbox">
	<!-- 当前位置 -->
	<div class="zy_weizhi bord_b">
		<i class="fa fa-home fa-3x"></i>
		<a>首页</a>
		<a>日用资料</a>
		<span>我的意向客户管理</span>
	</div>
	<!-- 筛选 -->
	<div class="shuaix">

		<div class="right">
			<form action="${pageContext.request.contextPath}/OrdersServlet?id=8&ye=1" method="post">
			书名：<input type="text" name="bookname">
			支付时间：从<input type="date" name="cdate">
			到<input type="date" name="ddate">

				<button type="submit">查询</button>
			</form>
		</div>
	</div>
	<!-- 下面写内容 -->
	<table class="layui-table" lay-filter="mylist" lay-size="lg">
		<thead>
		<tr>
<%--			<th lay-data="{type:'checkbox',fixed:'left'}"></th>--%>
			<th lay-data="{field:'yx', align:'center',width:60}">出版社</th>
			<th lay-data="{field:'time',align:'center', minWidth:170}">订单编号</th>
			<th lay-data="{field:'www',align:'center',minWidth:130}">书籍名称</th>
			<th lay-data="{field:'company',align:'center',minWidth:260}">书籍数量</th>
			<th lay-data="{field:'user',align:'center',width:130}">订单价格</th>
			<th lay-data="{field:'tel',align:'center',width:130}">支付时间</th>
			<th lay-data="{field:'option',align:'center',width:130,toolbar:'#barDemo',fixed: 'right'}">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:if test="${orlist!=null}">
		<c:forEach items="${orlist}" var="o">
		<tr>
			<td>${o.books.book_press}</td>
			<td>${o.order_number}</td>
			<td>${o.books.book_name}</td>
			<td>${o.orderDetails.book_number}</td>
			<td>${o.order_price}</td>
			<td>${o.order_date}</td>
            <td>   <a class="layui-btn layui-btn-xs" lay-event="edit" href="${pageContext.request.contextPath}/OrdersServlet?id=11&cid=${id}&ye=${ye}&oid=${o.order_id}&bookname=${o.books.book_name}">查看</a>

			<%--				<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" href="${pageContext.request.contextPath}/OrdersServlet?id=7&ye=${ye}&oid=${o.order_id}">删除</a>--%>
			</td>
		</tr>
		</c:forEach></c:if>>

		<c:if test="${list!=null}">
		<c:forEach items="${list}" var="o">
			<tr>
				<td>${o.books.book_press}</td>
				<td>${o.order_number}</td>
				<td>${o.books.book_name}</td>
				<td>${o.orderDetails.book_number}</td>
				<td>${o.order_price}</td>
				<td>${o.order_date}</td>
				<td>
                    <a class="layui-btn layui-btn-xs" lay-event="edit" href="${pageContext.request.contextPath}/OrdersServlet?id=11&cid=${id}&ye=${ye}&oid=${o.order_id}&bookname=${o.books.book_name}">查看</a>
<%--					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" href="${pageContext.request.contextPath}/OrdersServlet?id=10&ye=${ye}&oid=${o.order_id}">删除</a>--%>
                </td>
			</tr>
		</c:forEach>
		</c:if>>
		</tbody>
	</table>
	<c:if test="${orlist!=null}">
		<a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/OrdersServlet?id=6&ye=${ye-1}">上一页</a> ${ye}/${count}
		<a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/OrdersServlet?id=6&ye=${ye+1}">下一页</a>

	</c:if>
	<c:if test="${list!=null}">
		<a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/OrdersServlet?id=9&ye=${ye-1}">上一页</a> ${ye}/${count}
		<a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/OrdersServlet?id=9&ye=${ye+1}">下一页</a>

	</c:if>

</div>


<script>
	var ye=${ye};
	var count=${count};
	if (parseInt(ye)<=1){
		$(".syye").css("pointer-events","none");
		$(".syye").css("background-color","red");
	}
	if(parseInt(ye)>=parseInt(count)){
		$(".xyye").css("pointer-events","none");
		$(".xyye").css("background-color","red");
	}
</script>
</body>

</html>
