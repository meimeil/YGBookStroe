<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单信息</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
<body>
	<center>
    	<jsp:include page="top.jsp"></jsp:include>	
		<div id="managePage" style="width: 100%;height: 630px;background-color: white;">
			<div id="manageLeft">
				<jsp:include page="manageLeft.jsp"></jsp:include>
			</div>
			<div id="singleOrders"  style="width: 70%;">
			<s:action name="singleOrdersAction" executeResult="false"></s:action>
				<ul class="singleOrdersBook" style="background-color: rgb(23,157,244);">
					<li class="singleOrdersHead" style="color: white;text-align: left;padding-left: 10px;padding-top: 5px;">
						<s:property value="#request.orders.ordersNumber"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						总计金额：<s:property value="#request.orders.totalMoney"/> 元
						&nbsp;&nbsp;&nbsp;&nbsp;
						状态：
						<s:if test='#request.orders.isDeal == \'0\''>未处理</s:if>
						<s:else>已处理</s:else>
						&nbsp;&nbsp;&nbsp;&nbsp;
						日期：<s:date name="#request.orders.ordersTime" format="yyyy-MM-dd HH:mm:ss"/>
					</li>
				</ul>
				<ul class="singleOrdersBook" style="background-color: yellow;">
					<li class="sequence">序列</li>
					<li class="bookName">图书名称</li>
					<li class="bookPrice">图书价格</li>
					<li class="bookAmount">购买数量</li>
					<li class="bookPress">出版社</li>
				</ul>
				<s:iterator value="#request.bookList" status="st">
					<ul class="singleOrdersBook">
						<li class="sequence">
							<s:property value="#st.getIndex()+1"/>
						</li>
						<li class="bookName"><a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookid" />"><s:property value="bookName"/></a></li>
						<li class="bookPrice"><s:property value="bookPrice"/> 元</li>
						<li class="bookAmount">
							<s:property value="bookAmount"/>
						</li>
						<li class="bookPress">
							<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a>
						</li>
					</ul>
				</s:iterator>
				<ul class="singleOrdersFoot">
					<li class="singleOrdersFoot">
						<s:if test='%{#request.orders.isDeal == \'0\'}'>
							<a class="aboutOrders" href='../com.shop.action/dealOrdersAction.action?ordersId=<s:property value="#request.orders.ordersId"/>'>处理订单</a>
						</s:if>
						<s:else>
							----
						</s:else>
					</li>
				</ul>
			</div>
		</div>
	</center>
</body>
</html>
