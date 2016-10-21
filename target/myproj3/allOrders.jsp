<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的订单</title>
</head>
<body>
<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="orders">
			<div id="left">
				<jsp:include page="Left.jsp"></jsp:include>
			</div>
			<div id="ordersInfor"  style="padding-top: 20px;padding-left: 8px;">
				<ul class="singleOrders">
					<li style="width: 700px;padding-top: 10px;padding-left: 10px;text-align: left;background-color: #FF6600">
						<a class="aboutOrders" href="allOrders.jsp?searchType=all">所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="aboutOrders" href="allOrders.jsp?searchType=isDeal">已处理订单</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="aboutOrders" href="allOrders.jsp?searchType=isNotDeal">未处理订单</a>
					</li>
				</ul>
				<ul class="singleOrders" style="background-color: #FFFFCC;">
					<li class="sequence">序列</li>			
					<li class="ordersNumber">订单编号</li>			
					<li class="ordersTime">订单日期</li>			
					<li class="isDeal">处理状态</li>			
					<li class="deleteOrders" style="padding-top: 5px;">删除订单</li>			
				</ul>
				<s:action name="ordersAction" executeResult="false"></s:action>
				<s:iterator value="#request.allOrdersByUser" status="st">
					<ul class="singleOrders">
						<li class="sequence"><s:property value="#st.getIndex()+#request.sequence+1"/></li>			
						<li class="ordersNumber">
							<a class="aboutBook" href="singleOrders.jsp?ordersId=<s:property value="ordersId"/>"><s:property value="orderNumber"/></a>
						</li>			
						<li class="ordersTime"><s:date name="ordersTime" format="yyyy-MM-dd HH:mm:ss"/></li>			
						<li class="isDeal">
					
						<s:if test='%{isDeal==\'0\'}'><!--引用字符char，需要转义单引号。test语句用单双引号都可以  %｛｝执行-->
								<font style="color: green;">未处理</font>
							</s:if>
							<s:else>
								<font style="color: red;">已处理</font>
							</s:else>
						<%--在页面上设置变量 <s:set var="ststus" value="%{isDeal}" /><s:property value="#ststus"/>
							<s:if test="%{#ststus==\'0\'}">
								<font style="color: green;">未处理</font>
							</s:if>
							<s:else>
								<font style="color: red;">已处理</font>
							</s:else> --%>
						</li>
						<li class="deleteOrders">
							<input type="button" value="删除" onclick="deleteOrders('<s:property value="ordersId"/>')" class="button"/>
						</li>			
					</ul>
				</s:iterator>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
<SCRIPT type="text/javascript">
<!--
	function deleteOrders(ordersId){
		if(confirm("确定要删除订单吗？")){
			location.href="com.shop.action/ordersManageAction.action?updateType=delete&ordersId="+ordersId;
		}
	}
//-->
</SCRIPT>
</html>