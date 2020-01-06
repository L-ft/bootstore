<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的消息</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/qiantai/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/qiantai/js/jquery.min.js"></script>
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

    <div class="user_top">
       <div class="user_c">
         <div class="user_top_l">
             <a href="" target="_blank">回到首页</a>
             欢迎您，uesr  &nbsp;&nbsp;&nbsp;
             <a href="" target="_blank">退出</a>
         </div>
         <div class="user_top_r">
               <ul>
                   <li><a href="" target="_blank">帮助中心</a></li>
                   <li><a href="" target="_blank">关于我们</a></li>

               </ul>
         </div>
       </div>
    </div>
    
    <div class="user_nav">
         <div class="user_c">
               <div class="user_nav_l">用户中心</div>
               <div class="user_nav_r">
                     <input name="search2" type="text"  class="uesr_s"/>
                     <input name="search2" type="button"  class="uesr_b"/>
               </div>
         </div>
    </div>
    
    <div class="user_cont">
         <!--left begin -->
         <div class="user_cont_left">
               <dl>
                   <dt>我的交易</dt>
                   <dd><a href="">我的订单</a></dd>
                   <dd><a href="">我的收藏</a></dd>
                   <dd><a href="">我的账单</a></dd>
                   <dd><a href="">我的购物车</a></dd>
                   <dd><a href="">已经购买的商品</a></dd>
               </dl>
               <dl>
                   <dt>自助服务</dt>
                   <dd><a href="">申请查询退换货</a></dd>
                   <dd><a href="">查询退换货记录</a></dd>
               </dl>
               <dl>
                   <dt>我的账户</dt>
                   <dd><a href="">我的积分</a></dd>
                   <dd class="active"><a href="">我的消息</a></dd>
                   <dd><a href="">我的收获地址</a></dd>
                   <dd><a href="">个人档案</a></dd>
               </dl>
               <dl>
                   <dt>社区中心</dt>
                   <dd><a href="">我的评论</a></dd>
                   <dd><a href="">兑换专区</a></dd>
               </dl>
         </div>
         <script type="text/javascript">
$(document).ready(function(){
		$(".user_cont_left dl dt").click(function(){
		$(this).siblings().slideToggle("slow");
		$(this).toggleClass("jia"); return false;
	});
	
});
</script>
         <!--left end -->
         <!--right begin -->
         <div class="user_cont_right">
           <div class="user_lmt">
                    <div class="user_lmt1">我的消息</div>
                   
           </div>
               <div class="user_coment">
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
                    <!--分页开始 -->

                    <!--分页结束 -->
                   
           </div>
         </div>
         <!--right end -->
    </div>
    
    <div class="footer_m mar38">
           <div class="footer_nav">
               <a href="" target="_blank">关于我们</a>|
               <a href="" target="_blank">联系我们</a>|
               <a href="" target="_blank">人才招聘</a>|
               <a href="" target="_blank">广告服务</a>|
               <a href="" target="_blank">友情链接</a>|
               <a href="" target="_blank">销售联盟</a>|
               <a href="" target="_blank">公司简介</a>
           </div>
           <div class="footer_copyright">
                网络文化经营许可证鄂网文[2015]0278-060号  Copyright © 2015-2018  版权所有
           </div>
     </div>
    
</body>
</html>
