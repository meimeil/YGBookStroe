<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<center>
		<div id="top">
			<div width="100%" height="30px" style="margin-left: 0px;margin-top:10px;" align="left">
			<s:if test="%{#session.loginUser == null}">
			亲，欢迎来阳光书店！请 <a href="enroll.jsp">注册</a> &nbsp;|&nbsp;<a href="login.jsp">登录</a>
			</s:if>
			<s:else>
					<font style="color:green;font-weight: bold">
						 <s:property value="#session.loginUser.userName"/>
					</font>
					您好！欢迎光临阳光书店
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="firstPage.jsp"><font style="color: #FF6600;font-weight: bold;">首页</font></a>&nbsp;|&nbsp;<a href="personalInformation.jsp">个人信息</a> &nbsp;|&nbsp;<a href="shoppingCart.jsp">我的购物车</a>&nbsp;|&nbsp; <a href="allOrders.jsp">我的订单</a> &nbsp;|&nbsp;<a href="http://school.itzcn.com/help.html" target="_blank">帮助中心</a>
				| <a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.baidu.com');" href="#">设为首页</a> | <a href="javascript:window.external.AddFavorite('http://www.baidu.com')">加入收藏</a>&nbsp;|&nbsp;
					<a href="com.shop.action/userExitAction.action?userType=ordinaryUser">安全退出</a>
			</s:else>
			</div>
			
			<div id="logo" >
				<a href="http://www.baidu.com"><img src="image/logo.png"/></a>
			</div>
			
			<div id="searchBook" >
					<br/>
					<input type="radio" name="searchType" value="bookName" checked="checked"/>名称
					<input type="radio" name="searchType" value="bookAuthor"/>作者
					<input type="radio" name="searchType" value="bookPress"/>出版社<br/>
					<input type="text" name="searchDescribe" id="searchDescribeID" class="input" />
			</div>
			<div>
					<input type="button"  onclick="searchBook()" style="width: 131px;height: 35px;background-image:url(image/search.jpg)" class="search"/>
			
			</div>
			<div  style="margin-top: 2px;width:100%;float:left"><hr/></div>
			
		</div>
	</center>
</body>
<SCRIPT type="text/javascript">
<!--
	function searchBook(){
		var searchType = "";
		for (i=0;i<document.all.searchType.length;i++){
		    if (document.all.searchType[i].checked){
		    	searchType = document.all.searchType[i].value;
		    }
	    }
		var searchDescribe = document.getElementById("searchDescribeID").value;
		location.href="oneType.jsp?searchType="+searchType+"&searchDescribe="+searchDescribe;
	}
//-->
</SCRIPT>
</html>