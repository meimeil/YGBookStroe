<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
</head>
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="shoppingCart">
			<div id="left">
				<jsp:include page="Left.jsp"></jsp:include>
			</div>
			<div id="shoppingBook">
				<ul class="shoppingBookUl">
					<li class="shoppingBookHead">我的购物车</li>
				</ul>
				<ul class="shoppingBookUl" style="background-color: #FFFFCC;">
					<li class="sequence">序列</li>
					<li class="bookName">图书名称</li>
					<li class="bookPrice">图书价格</li>
					<li class="bookAmount" style="padding-top: 5px;">购买数量</li>
					<li class="delete" style="padding-top: 5px;">删除图书</li>
				</ul>
				<s:if test="%{#session.shoppingBook != null}">
					<s:iterator value="#session.shoppingBook" status="st">
						<ul class="shoppingBookUl">
							<li class="sequence"><s:property value="#st.getIndex()+1"></s:property></li>
							<li class="bookName"><a class="bookName"
								href="singleBook.jsp?bookId=<s:property value="bookid" />">
									<s:property value="bookName" />
							</a></li>
							<li class="bookPrice"><s:property value="bookPrice" />元</li>
							<li class="bookAmount"><input type="text"
								id="bookAmount<s:property value="bookid"/>"
								value='<s:property value="bookAmount"/>' /> <input type="button"
								value="修改"
								onclick="updateBookAmount('<s:property value="bookid"/>')" /></li>
							<li class="delete"><input type="button" value="删除"
								onclick="deleteBook('<s:property value="bookid"/>')" /></li>

						</ul>
					</s:iterator>
					<ul class="shoppingBookUl">
						<li class="shoppingBookHead"><s:if
								test="%{#session.shoppingBook.size() > 0}">
								<input type="button" value="确定购买" onclick="addOrders()">
							
							</s:if> 总计金额：<span id="totalMoney2"></span>&nbsp;&nbsp;&nbsp;元</li>
					</ul>
					</s:if>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
	

</body>
<script text="text/javascript">
//<!--
function updateBookAmount(bookId){
	var pattern = /^[1-9][0-9]{0,}$/;
	var bookAmount = document.getElementById("bookAmount"+bookId).value;
	if(pattern.test(bookAmount)){
		location.href = "com.shop.action/updateCartAction.action?updateType=update&bookId="+bookId+"&bookAmount="+bookAmount;
	}
}
function deleteBook(bookId){
	if(confirm("确定要删除吗？")){
		location.href = "com.shop.action/updateCartAction.action?updateType=delete&bookId="+bookId;
	}
}
function addOrders(){
	if(confirm("确定要购买吗？")){
		location.href = "com.shop.action/ordersManageAction.action?updateType=add";
	}
}
function formatDouble(){
	
	 var money = "<%=session.getAttribute("totalMoney")%>";//string
	 var str=parseFloat(money);//float
	 str=str.toFixed(2);
	 document.getElementById("totalMoney2").innerHTML=str;
}
formatDouble();
//-->
</script>

</html>