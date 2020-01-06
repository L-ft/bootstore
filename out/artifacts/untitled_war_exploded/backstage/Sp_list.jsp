<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"reception"+"/";
%>
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
            <a>商品订单管理</a>
            <span>商品订单状态查询</span>
        </div>
        <!-- 筛选 --> 
	<div class="shuaix"> 
            <div class="right">
                <table>
                    <form action="${pageContext.request.contextPath}/OrdersServlet?id=3&ye=1" method="post">
                <tr>
                    <td> 商品订单编号：<input type="text" placeholder="请输入商品订单编号" name="oid"></td>
                    <td> 配送地址：<input type="text" placeholder="请输入配送地址" name="address"></td>

                </tr>
               <tr>
                   <td> 订单审核状态：<select name="staus">
                              <option value="10">所有</option> 　　
                               <option value="0">未支付</option> 　　　
                       　　　　<option value="1">已支付,未发货</option>
                               <option value="2">已发货</option>
                               <option value="3">已收货</option>
                               <option value="4">已退货</option>
                       　　</select>
                   </td>
                   <td>下单时间：从<input type="date" name="congdate"></td>
                   <td> 到<input type="date" name="daodate"></td>
                   <td><button type="submit">查询</button></td>
               </tr>
                    </form>
                </table>



            </div>
        </div>
        <!-- 下面写内容 -->
        <table class="layui-table" lay-filter="mylist" lay-size="lg">
            <thead>
                <tr>

                    <th lay-data="{field:'time',align:'center', minWidth:220}">订单编号</th>
                    <th lay-data="{field:'www',align:'center',minWidth:170}">会员编号</th>
                    <th lay-data="{field:'company',align:'center',minWidth:130}">配送地址</th>
                    <th lay-data="{field:'user',align:'center',width:130}">配送方式</th>
                    <th lay-data="{field:'tel',align:'center',width:130}">下单时间</th>
                    <th lay-data="{field:'result',align:'center',minWidth:130}">商品名称</th>
                    <th lay-data="{field:'addr',align:'center',minWidth:130}">订单价格</th>
                    <th lay-data="{field:'addr2',align:'center',minWidth:130}">订单审核状态</th>
                    <th lay-data="{field:'option',align:'center',width:130,toolbar:'#barDemo',fixed: 'right'}">操作</th>
                </tr> 
            </thead>
            <tbody>
            <c:if test="${ordelist!=null}">
          <c:forEach items="${ordelist}" var="o" varStatus="i" >
                <tr>
                    <td>${o.order_number}</td>
                    <td>${o.user_id}</td>
                    <td>${address[i.count-1].receiving_address}</td>
                    <td>快递</td>
                    <td>${o.order_date}</td>
                    <td>${books[i.count-1].book_name}</td>
                    <td>${o.order_price}</td>
                    <c:if test="${o.order_status==0}"><td>未支付</td></c:if>
                    <c:if test="${o.order_status==1}"><td>已支付，未发货</td></c:if>
                    <c:if test="${o.order_status==2}"><td>已发货</td></c:if>
                    <c:if test="${o.order_status==3}"><td>已收货</td></c:if>
                    <c:if test="${o.order_status==4}"><td>已退货</td></c:if>

                    <td>
                        <a href="${pageContext.request.contextPath}/OrdersServlet?id=12&ye=${ye}&number=${o.order_number}&book=${books[i.count-1].book_name}&cid=${id}">查看</a>
<%--                        <a href="${pageContext.request.contextPath}/OrdersServlet?id=2&ye=${ye}&oid=${o.order_id}">删除</a>--%>
                   </td>
                </tr>
            </c:forEach>
            </c:if>

            <c:if test="${list!=null}">
                <c:forEach items="${list}" var="o" varStatus="i" >
                    <tr>
                        <td>${o.order_number}</td>
                        <td>${o.user_id}</td>
                        <td>${o.reces.receiving_address}</td>
                        <td>快递</td>
                        <td>${o.order_date}</td>
                        <td>${o.books.book_name}</td>
                        <td>${o.order_price}</td>
                        <c:if test="${o.order_status==0}"><td>未支付</td></c:if>
                        <c:if test="${o.order_status==1}"><td>已支付，未发货</td></c:if>
                        <c:if test="${o.order_status==2}"><td>已发货</td></c:if>
                        <c:if test="${o.order_status==3}"><td>已收货</td></c:if>
                        <c:if test="${o.order_status==4}"><td>已退货</td></c:if>
                        <td>
                            <a href="${pageContext.request.contextPath}/OrdersServlet?id=12&ye=${ye}&number=${o.order_number}&book=${o.books.book_name}&cid=${id}">查看</a>
<%--                            <a href="${pageContext.request.contextPath}/OrdersServlet?id=5&ye=${ye}&oid=${o.order_id}">删除</a>--%>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

            </tbody>  
        </table>
        <c:if test="${ordelist!=null}">
            <a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/OrdersServlet?id=1&ye=${ye-1}">上一页</a> ${ye}/${count}
            <a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/OrdersServlet?id=1&ye=${ye+1}">下一页</a>

        </c:if>
        <a  onclick="x()">${jh.leng}</a>
        <c:if test="${list!=null}">
            <a class="layui-btn layui-btn-xs syye" lay-event="edit" href="${pageContext.request.contextPath}/OrdersServlet?id=4&ye=${ye-1}">上一页</a> ${ye}/${count}
            <a class="layui-btn layui-btn-danger layui-btn-xs xyye" lay-event="del" href="${pageContext.request.contextPath}/OrdersServlet?id=4&ye=${ye+1}">下一页</a>

        </c:if>



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
    </div>

   <!-- 自定义头部工具栏 -->
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container"> 
            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">删除</button> 
        </div>
    </script> 
	<!-- houl --> 
	<!-- 结束 -->
    <!-- layui js -->
    <script src="layui/layui.js"></script>
    
</body>

</html> 
