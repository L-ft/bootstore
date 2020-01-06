<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<a>当前位置</a>
		<a>供应商商品管理</a>
		<span>商品基本信息管理</span>
	</div>
	<!-- 筛选 --> 
	<div class="shuaix">
		<form action="${pageContext.request.contextPath}/FindLikeBook" method="post">
		<div class="right">
			<input type="text" placeholder="请输入商品名" name="book_name">
			<input type="text" placeholder="请输入作者" name="book_auth">
			<input type="text" placeholder="请输入出版社" name="book_press">
			<input type="submit" value="查询">
			<a href="backstage/guodu.jsp">添加</a>
		</div>
		</form>
	</div>
	<!-- 下面写内容 -->
	<table class="layui-table" lay-filter="mylist" lay-size="lg">
		<thead>
			<tr>
				<th lay-data="{type:'checkbox',fixed:'left'}"></th>
				<th lay-data="{field:'yx', align:'center',width:60}">商品编号</th>
				<th lay-data="{field:'time',align:'center', minWidth:70}">商品名</th>
				<th lay-data="{field:'www',align:'center',minWidth:10}">商品价格</th>
				<th lay-data="{field:'company',align:'center',minWidth:10}">折扣价</th>
				<th lay-data="{field:'user',align:'center',width:80}">详情</th>
				<th lay-data="{field:'tel',align:'center',width:70}">审核状态</th>
				<th lay-data="{field:'result',align:'center',minWidth:20}">类型</th>
				<th lay-data="{field:'addr',align:'center',minWidth:50}">适合年级</th>
				<th lay-data="{field:'addr1',align:'center',minWidth:20}">作者</th>
				<th lay-data="{field:'addr2',align:'center',minWidth:50}">出版社</th>
				<th lay-data="{field:'addr3',align:'center',minWidth:50}">出版时间</th>
<%--				<th lay-data="{field:'option',align:'center',width:130,toolbar:'#barDemo',fixed: 'right'}">操作</th>--%>
				<th lay-data="{field:'addr4',align:'center',minWidth:50}">操作</th>
			</tr> 
		</thead>
		<c:forEach items="${bookinfos}" var="book">
		<tbody>
			<tr>
				<td></td>
				<td>${book.book_id}</td>
				<td>${book.book_name}</td>
				<td>${book.book_price}</td>
				<td>${book.book_discountprice}</td>
				<td>${book.book_details}</td>
				<c:if test="${book.book_status==1}">
					<td>通过</td>
				</c:if>
				<c:if test="${book.book_status==0}">
					<td>待审批</td>
				</c:if>
				<c:if test="${book.book_status==null}">
					<td>不通过</td>
				</c:if>
				<c:if test="${book.book_typeid<4}">
					<td>教育</td>
				</c:if>
				<c:if test="${book.book_typeid>=4}">
					<td>工具书</td>
				</c:if>
				<c:if test="${book.book_fitclass<=6}">
					<td>小学</td>
				</c:if>
				<c:if test="${book.book_fitclass>6}">
					<c:if test="${book.book_fitclass<10}">
						<td>初中</td>
					</c:if>

				</c:if>
				<c:if test="${book.book_fitclass>=10}">
					<td>高中</td>
				</c:if>
				<td>${book.book_auth}</td>
				<td>${book.book_press}</td>
				<td>${book.book_date}</td>
				<td>

					<a href="${pageContext.request.contextPath}/DeleteBook?book_id=${book.book_id}">删除</a>
				</td>
			</tr>

		</tbody>
		</c:forEach>
	</table>

</div> 
<script type="text/javascript">
	//静态表格
    layui.use('table',function(){
    	var table = layui.table;
		//转换静态表格
		table.init('mylist', {
		  height: 'full-130' //高度最大化减去差值,也可以自己设置高度值：如 height:300
		  ,count: 50 //数据总数 服务端获得
		  ,limit: 5 //每页显示条数 注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
		  ,page:true //开启分页
		  ,toolbar: 'default'//工具栏
		  ,defaultToolbar:['filter', 'exports']
		  ,limits:[10, 20, 30, 40, 50]//分页显示每页条目下拉选择
		  ,cellMinWidth: 60//定义全局最小单元格宽度，其余自动分配宽度
		});
		// //监听行工具事件
		// table.on('tool(mylist)', function(obj){ //注：tool 是工具条事件名，mylist 是 table 原始容器的属性 lay-filter="对应的值"
		// 	var data = obj.data //获得当前行数据
		// 	,layEvent = obj.event; //获得 lay-event 对应的值
		// 	if(layEvent === 'del'){
		// 	    layer.confirm('真的删除行么', function(index){
		// 		    obj.del(); //删除对应行（tr）的DOM结构
		// 		    layer.close(index);
		// 		    //向服务端发送删除指令
		// 	    });
		// 	} else if(layEvent === 'edit'){
		// 	    layer.msg('修改操作');
		// 	}
		// });
		// //监听头工具栏事件
		// table.on('toolbar(mylist)', function(obj){
		// 	var checkStatus = table.checkStatus(obj.config.id)
		// 	,data = checkStatus.data; //获取选中的数据
		// 	switch(obj.event){
		// 	case 'add':
		// 		//iframe窗
		// 		layer.open({
		// 		type: 2,//层类型
		// 		title: "添加信息",//标题
		// 		closeBtn: 1, //不显示关闭按钮
		// 		shade: [0.3],//遮罩
		// 		skin: 'demo_class_color',//iframe皮肤
		// 		shadeClose:Boolean,//点击遮罩关闭
		// 		area: ['800px', '460px'],
		// 		// offset: 'rb', //右下角弹出
		// 		// time: 2000, //2秒后自动关闭
		// 		anim: 5,//动画
		// 		content: ['guodu.html', 'no'], //iframe的url，no代表不显示滚动条
		// 		});
		// 		//
		// 	break;
		// 	case 'update':
		// 		if(data.length === 0){
		// 		layer.msg('请选择一行');
		// 		} else if(data.length > 1){
		// 		layer.msg('只能同时编辑一个');
		// 		} else {
		// 		layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
		// 		}
		// 	break;
		// 	case 'delete':
		// 		if(data.length === 0){
		// 		layer.msg('请选择一行');
		// 		} else {
		// 		layer.msg('删除');
		// 		}
		// 	break;
		// 	};
		// });
	});
</script>


</body>

</html>
