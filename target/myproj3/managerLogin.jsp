<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<center>
	
		<div id="managerLogin">
			<h1>管理员登录</h1><br/>
			<s:form action="managerLoginAction">
				<s:textfield label="用户名" name="userName"></s:textfield>
				<s:password label="密码" name="userPassword"></s:password>
				<s:submit value="登录"></s:submit>
			</s:form>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
</html>