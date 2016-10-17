<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
</head>
<body>
<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="personalInformation">
		<s:if test="%{#session.loginUser != null}">
			<h1>个人信息</h1><br/>
			<s:form action="userInforAction" method="post"><!--s:select标签的value来指定默认选中，首先还要让sextype和sex lazy=false  -->
				<s:label label="用户名" name="userName" value="%{#session.loginUser.userName}"></s:label>
				<s:textfield label="昵称" name="userNickname" value="%{#session.loginUser.userNickname}"></s:textfield>
				<s:select label="性别" name="sexId" list="#{'0':'未知','1':'男','2':'女'}" value="%{#session.loginUser.sex.sexId}"></s:select>
				<s:textfield label="邮箱" name="userEmail" value="%{#session.loginUser.userEmail}"></s:textfield>
				<s:textfield label="电话" name="userPhone" value="%{#session.loginUser.userPhone}"></s:textfield>
				<s:textfield label="地址" name="userAddress" value="%{#session.loginUser.userAddress}"></s:textfield>
				<s:textarea label="备注" name="userRemark" value="%{#session.loginUser.userRemark}"></s:textarea>
				<s:submit value="修改"></s:submit>
			</s:form>
			<a href="updatePassword.jsp">修改密码</a>
		</s:if>
		<s:else>
			<jsp:forward page="firstPage.jsp"></jsp:forward>
		</s:else>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
</html>