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
            <a>当前位置</a>
            <a>系统管理</a>
            <span>供应商管理</span>
        </div>
        <!-- 内容 -->    
        <div class="wenxts_ke">
            <p><i>温馨提示：</i>填写回访记录后需要经由领导审阅回复，请认真填写</p>
        </div>
        <div class="kehubh_tj_k">

                <table style="width: 800px;height: 500px;border: 1px solid #CCCCCC;font-size: 20px;text-align: center">
                    <tr style="border: 1px solid #CCCCCC">
                        <td>会员id</td>
                        <td>${login.arid}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>登录名</td>
                        <td>${login.arname}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>密码</td>
                        <td>${login.arpassword}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>部门</td>
                        <td>${login.bumen}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>权限</td>
                        <td>${login.quanxian}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>单位</td>
                        <td>${login.danwei}</td>
                    </tr>
                    <tr>
                        <td>区/县</td>
                        <td>${login.address}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>手机号</td>
                        <td>${login.phone}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>email</td>
                        <td>${login.email}</td>
                    </tr>
                    <tr style="border: 1px solid #CCCCCC">
                        <td>qq</td>
                        <td>${login.qq}</td>
                    </tr>
<%--                    <tr style="border: 1px solid #CCCCCC">--%>
<%--                        <td style="text-align: center"><a href="${pageContext.request.contextPath}/FindAll"><input type="button" value="返回"></a></td>--%>
<%--                    </tr>--%>
                </table>

        </div>
    </div>   
    
	<!-- houl --> 
	<!-- 结束 -->
    <!-- layui js -->
    <script src="layui/layui.js"></script>
    
</body>

</html>



</script>
