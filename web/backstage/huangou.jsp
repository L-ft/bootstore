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
			<form action="${pageContext.request.contextPath}/JifenduihuanServlet?id=5&ye=1" method="post">
				<p>
			订单编号：<input type="text" name="dingdan">
			换购积分：<select name="jifen" style="border: 1px solid black">
					<option value="0">所有</option> 　　
					<option value="0-100">0-100</option> 　　　
					<option value="100-200">101-200</option>
					<option value="200">200以上</option>
					　　</select>
                </p>

                <p>
			商品名称：<input type="text" name="spname">
	   发货状态：<select id="select" class="sel" name="ztai" style="border: 1px solid black">
					<option value="">所有</option> 　　 　
					<option value="1">已支付,未发货</option>
					<option value="2">已发货</option>
					<option value="3">已收货</option>
					<option value="4">已退货</option>
					</select>




				<button type="submit">查询</button></p>
			</form>
		</div>
	</div>
	<!-- 下面写内容 -->
	<table class="layui-table" lay-filter="mylist" lay-size="lg">
		<thead>
		<tr>
<%--			<th lay-data="{type:'checkbox',fixed:'left'}"></th>--%>
			<th lay-data="{field:'yx', align:'center',width:60}">会员账号</th>
			<th lay-data="{field:'time',align:'center', minWidth:170}">订单编号</th>
			<th lay-data="{field:'www',align:'center',minWidth:130}">换购积分</th>
			<th lay-data="{field:'company',align:'center',minWidth:260}">商品名称</th>
         	<th lay-data="{field:'tel',align:'center',width:130}">记录时间</th>
        	<th lay-data="{field:'tel',align:'center',width:130}">发货状态</th>
			<th lay-data="{field:'user',align:'center',width:130}">送货地址</th>
			<th lay-data="{field:'option',align:'center',width:130,toolbar:'#barDemo',fixed: 'right'}">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${orders}" var="o">
		<tr>
			<td>${o.user_id}</td>
			<td>${o.order_number}</td>
			<td>${o.integral}</td>
			<td>${o.books.book_name}</td>
			<td>${o.order_date}</td>

			<c:if test="${o.order_status==1}"><td>已支付，未发货</td></c:if>
			<c:if test="${o.order_status==2}"><td>已发货</td></c:if>
			<c:if test="${o.order_status==3}"><td>已收货</td></c:if>
			<c:if test="${o.order_status==4}"><td>已退货</td></c:if>
			<td>${o.reces.receiving_address}</td>
			<td><a href="${pageContext.request.contextPath}/JifenduihuanServlet?id=7&ye=${ye}&cid=${id}&number=${o.order_number}&name=${o.books.book_name}">查看</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:if test="${pd==5}">
		<a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=4&ye=${ye-1}">上一页</a> ${ye}/${count}
		<a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=4&ye=${ye+1}">下一页</a>

	</c:if>
	<c:if test="${pd==6}">
		<a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=6&ye=${ye-1}">上一页</a> ${ye}/${count}
		<a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=6&ye=${ye+1}">下一页</a>

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
