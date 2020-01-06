
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<title>购书网后台</title>

	<!-- CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/css/children.css">

	<!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<!-- layui css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/layui/css/layui.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/js/jquery-1.11.0.min.js"></script>

</head>

<body class="layui-layout-body control_box">
<!-- 背景 -->
<div class="bg_box" style="background: url(images/20190415.jpg) no-repeat center center; background-size: cover;"></div>
<!-- content box-->
<div class="layui-layout layui-layout-admin">
	<!-- top -->
	<div class="layui-header">
		<div class="top_box">
			<div class="logo">
				<img src="images/logo_touming.gif">
				<span></span>
				<b><img src="images/word.png" /></b>
			</div>

			<div class="top_user">
				<span><img src="images/head.jpg" /></span>
				<dl>
					<dt>${login.arname}正在使用此系统 </dt>
					<dt>所在单位：${login.danwei} | 所在部门: ${login.bumen} | 权限: ${login.quanxian}</dt>
				</dl>
			</div>

			<div class="top_icon">
				<a href="index.html" title="首页"><img src="images/top_home.png"></a>
				<a href="#" title="个人设置"><img src="images/top_person.png"></a>
				<a href="login.jsp" title="退出"><img src="images/top_exit.png"></a>
			</div>
		</div>
	</div>
	<!-- side menu -->
	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
				<li class="layui-nav-item layui-nav-itemed">
					<a class="" href="javascript:;"><i class="fa fa-clipboard fa-fw"></i>供应商商品管理</a>
					<dl class="layui-nav-child">
						<dd><a href="${pageContext.request.contextPath}/findallBook" target="main_self_frame">商品基本信息管理</a></dd>
						<dd><a href="${pageContext.request.contextPath}/FindallComment" target="main_self_frame">商品评论信息管理</a></dd>
						<dd><a href="${pageContext.request.contextPath}/FindBookdiscount" target="main_self_frame">促销商品信息管理</a></dd>
						<c:if test="${login.quanxian=='M'}"><dd><a href="${pageContext.request.contextPath}/FindBookstatus" target="main_self_frame">商品审核管理</a></dd></c:if>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;"><i class="fa fa-shield fa-fw"> 商品订单管理</i></a>
					<dl class="layui-nav-child">

						<dd><a href="${pageContext.request.contextPath}/OrdersServlet?id=1&ye=1"  target="main_self_frame">商品订单状态查询管理</a></dd>
						<dd><a href="${pageContext.request.contextPath}/OrdersServlet?id=6&ye=1"  target="main_self_frame">商品销售额查询管理</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;"><i class="fa fa-shield fa-fw"></i>系统管理</a>
					<dl class="layui-nav-child">

						<dd><a href="gongyinshang.jsp"  target="main_self_frame">供应商管理</a></dd>

					</dl>
				</li>
				<li class="layui-nav-item">
					<c:if test="${login.quanxian=='M'}">
					<a href="javascript:;"><i class="fa fa-address-card fa-fw"></i>积分兑换商品管理</a>
					<dl class="layui-nav-child">
						<dd><a href="${pageContext.request.contextPath}/JifenduihuanServlet?id=1&ye=1" target="main_self_frame">积分来源信息管理</a></dd>
						<dd><a href="${pageContext.request.contextPath}/JifenduihuanServlet?id=4&ye=1" target="main_self_frame">积分兑换商品信息管理</a></dd>
					</dl>
					</c:if>
				</li>

				<li class="layui-nav-item" >
					<c:if test="${login.quanxian=='M'}">
					<a href="javascript:;"><i class="fa fa-user fa-fw"></i>会员管理</a>
					<dl class="layui-nav-child">
						<dd><a href="${pageContext.request.contextPath}/FindAll" target="main_self_frame">会员信息管理</a></dd>

					</dl>
					</c:if>
				</li>

			</ul>
		</div>
	</div>

	<div class="layui-body">
		<!-- 展开收起按钮 -->
		<div class="open_shrink open" title="展开/收起">
			<span></span>
		</div>
		<script type="text/javascript">
			$(function(){
				$(".open_shrink").click(function(){
					if ($(this).hasClass("open")) {
						$(this).removeClass("open");
						$(".layui-side").stop().animate({left:-220},300);
						$(".layui-body").stop().animate({left:0},300);
					}else{
						$(this).addClass("open");
						$(".layui-side").stop().animate({left:0},300);
						$(".layui-body").stop().animate({left:220},300);
					}
				})
			})
		</script>
		<!-- iframe -->
		<iframe src="daily_mykh.jsp" name="main_self_frame" frameborder="0" class="layadmin-iframe" scrolling="yes"></iframe>
	</div>

</div>
<!-- layui js -->
<script src="layui/layui.js"></script>
<script>

	//JavaScript代码区域
	layui.use('element', function(){
		var element = layui.element;

	});

</script>

</body>

</html>

