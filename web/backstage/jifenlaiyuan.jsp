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
			<form action="${pageContext.request.contextPath}/JifenduihuanServlet?id=2&ye=1" method="post">
				<p>
				会员账号：<input type="text" name="huiyuan">
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
	   商品类型：<select id="select" class="sel" name="yiji" style="border: 1px solid black">
						<option value="所有">所有</option>
						<option value="教育">教育</option>
						<option value="工具书">工具书</option>
						<option value="小学">小学</option>
						<option value="初中">初中</option>
						<option value="高中">高中</option>
					</select>

					<select id="val" class="sel" name="erji" style="border: 1px solid black"></select>　
					<script type="text/javascript">
						var select = document.getElementById("select");
						document.getElementById("val").innerHTML="<option>所有</option>";
						select.onchange=function(){
							var selvalue = select.value;
							var val = document.getElementById("val");
							switch(selvalue){

								case "教育" : val.innerHTML="<option>所有</option><option>教材</option><option>外语考试</option><option>中小学教辅</option>";break;
								case "工具书" : val.innerHTML="<option>所有</option><option>汉语工具书</option><option>英语工具书</option><option>其他语种工具书</option><option>百科全书</option><option>文学鉴赏</option><option>辞典</option><option>牛津系列</option><option>朗文系列种工具</option><option>英文原版书</option><option>民族语工具书</option>";break;
						    	case "小学" : val.innerHTML="<option>所有</option><option>小学一年级</option><option>小学二年级</option><option>小学三年级</option><option>小学四年级</option><option>小学五年级</option><option>小学六年级</option>";break;
								case "初中" : val.innerHTML="<option>所有</option><option>初中一年级</option><option>初中二年级</option><option>初中三年级</option>";break;
								case "高中" : val.innerHTML="<option>所有</option><option>高中一年级</option><option>高中二年级</option><option>高中三年级</option>";break;
								case "所有" : val.innerHTML="<option>所有</option>";break;
								default : alert("erro");
							}
						};
					</script>

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
			<th lay-data="{field:'www',align:'center',minWidth:130}">积分</th>
			<th lay-data="{field:'company',align:'center',minWidth:260}">商品名称</th>
         	<th lay-data="{field:'tel',align:'center',width:130}">商品图片</th>
        	<th lay-data="{field:'tel',align:'center',width:130}">商品类型</th>
			<th lay-data="{field:'user',align:'center',width:130}">商品描述</th>
			<th lay-data="{field:'option',align:'center',width:130,toolbar:'#barDemo',fixed: 'right'}">操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${orders}" var="o">
		<tr>
			<td>${o.user_id}</td>
			<td>${o.order_number}</td>
			<td>${o.jifen}</td>
			<td>${o.books.book_name}</td>
			<td><img src="${o.books.book_img}" ></td>
			<td>${o.bt.booktype_name}/${o.bt.booktype_detailname}</td>
			<td>${o.books.book_details}</td>
			<td><a href="${pageContext.request.contextPath}/JifenduihuanServlet?id=8&ye=${ye}&cid=${id}&number=${o.order_number}&name=${o.books.book_name}">查看</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:if test="${pd==1}">
		<a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=1&ye=${ye-1}">上一页</a> ${ye}/${count}
		<a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=1&ye=${ye+1}">下一页</a>

	</c:if>
	<c:if test="${pd==2}">
		<a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=3&ye=${ye-1}">上一页</a> ${ye}/${count}
		<a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/JifenduihuanServlet?id=3&ye=${ye+1}">下一页</a>

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
