<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申请查询退换货</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/qiantai/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/qiantai/js/jquery.min.js"></script>
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
                   <dd  class="active"><a href="">申请查询退换货</a></dd>
                   <dd><a href="">查询退换货记录</a></dd>
               </dl>
               <dl>
                   <dt>我的账户</dt>
                   <dd><a href="">我的积分</a></dd>
                   <dd><a href="">我的消息</a></dd>
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
         <div class="user_cont_right" >
           <div class="user_lmt">
                    <div class="user_lmt1">申请查询退换货</div>
                    
           </div>
               <div class="user_coment">
                 <table  border="0" cellspacing="0" cellpadding="0"  class="my_dd">
                       <tr>
                           <th height="48" width="90">订单编号</th>
                            <th height="48" colspan="2">书籍信息</th>
                            <th width="90" height="48">订单状态</th>
                            <th width="90">商品实付款</th>
                           <th width="100">订单总付款</th>
                           <th width="100">操作</th>
                        </tr>
                     <c:forEach items="${olist}" var="o">
                        <tr>

                            <td width="90">${o.order_number}</td>
                            <td width="90">
                                 <div class="dd_img"><a href="" target="_blank"><img src="${o.books.book_img}" width="132" height="121" /></a></div>
                               
                            </td>
                            <td width="100" style="padding:0 5px; text-align:left;"><a href="" target="_blank">${o.books.book_details}</a></td>
                            <c:if test="${o.order_status==1}">
                                <td width="100">已付款，未发货</td>
                            </c:if>
                            <c:if test="${o.order_status==2}">
                                <td width="100">已发货</td>
                            </c:if>
                            <c:if test="${o.order_status==3}">
                                <td width="100">已收货</td>
                            </c:if>

                            <td>${o.books.book_discountprice}(元)</td>
                            <td>${o.order_price}(元)</td>
                            <td colspan="2" style=" text-align:left;padding-left:20px;">
                                 <div class="user_ck"><a href="${pageContext.request.contextPath}/TuiHuoServlet?jifen=${o.order_price}&number=${o.order_number}&ye=${ye}" target="_blank">申请退货</a></div>

                            </td>
                        </tr>
                     </c:forEach>
                    </table>
                    <!--分页开始 -->
                 <div style="clear:both;"></div>
                    <div class="fenyeys" >

                    <a href="TuiHuoshenqingServlet?ye=${ye-1}">上一页</a>
                        ${ye}/${count}
                    <a href="TuiHuoshenqingServlet?ye=${ye+1}">下一页</a>

                    </div>
                    <div style="clear:both;"></div>
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
