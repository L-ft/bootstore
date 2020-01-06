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
    <title>商品评论信息管理</title>

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
            <a>当前位置：</a>
            <a>供应商商品管理>></a>
            <span>商品评论信息管理</span>
        </div>
        <!-- 筛选 --> 
        <div class="shuaix">
            <form action="${pageContext.request.contextPath}/FindByLikeComment" method="post">
            <div class="right">
                <input type="text" placeholder="请输入评论内容" name="comment_content">
                <input type="submit" value="查询">
            </div>
            </form>
        </div>
        <!-- 下面写内容 -->
        <table class="layui-table" lay-filter="mylist" lay-size="lg">
            <thead>
                <tr> 
                    <th lay-data="{field:'yx', align:'center',width:60}">编号</th>
                    <th lay-data="{field:'time',align:'center', minWidth:70}">会员编号</th>
                    <th lay-data="{field:'www',align:'center',minWidth:30}">书籍编号</th>
                    <th lay-data="{field:'company',align:'center',minWidth:80}">评论内容</th>
                    <th lay-data="{field:'company1',align:'center',minWidth:80}">评论时间</th>
                    <th lay-data="{field:'user',align:'center',width:230}">书籍名称</th>
                    <th lay-data="{field:'addr',align:'center',minWidth:260}">操作</th>
                </tr> 
            </thead>
            <c:forEach items="${commentdtos}" var="comment">
            <tbody>
                <tr> 
                    <td>${comment.comment_id}</td>
                    <td>${comment.book_id}</td>
                    <td>${comment.user_id}</td>
                    <td>${comment.comment_content}</td>
                    <td>${comment.comment_date}</td>
                    <td>${comment.book_name}</td>
                    <td>
                        <a href="backstage/instercomment.jsp">添加</a>
                        <a href="${pageContext.request.contextPath}/DeleteComment?book_id=${comment.comment_id}">删除</a>
                    </td>

                </tr>
            </tbody>
            </c:forEach>
        </table>

    </div>

    <!-- layui js -->
    <script src="${pageContext.request.contextPath}/backstage/layui/layui.js"></script>
    
</body>

</html>
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
		  //,toolbar: 'default'//工具栏
		  ,defaultToolbar:['filter', 'exports']
		  ,limits:[10, 20, 30, 40, 50]//分页显示每页条目下拉选择
		  ,cellMinWidth: 60//定义全局最小单元格宽度，其余自动分配宽度
		});  
	}); 
</script> 
