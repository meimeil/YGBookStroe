<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<center>
	<jsp:include page="top.jsp"></jsp:include>
	<s:if test="%{#session.loginUser!=null}" >
	<h1>修改密码</h1>
	<s:form action="updatePasswordAction" method="post">
	<s:textfield lable="原密码"></s:textfield>
	<s:textfield lable="新密码"></s:textfield>
	<s:textfield lable="确认密码"></s:textfield>
	<s:submit value="修改密码"></s:submit>
	</s:form>
	</s:if>
	<s:else>
	<jsp:include page="firstPage.jsp"></jsp:include>
	</s:else>
	<jsp:include page="bottom.html"></jsp:include>
</center>
</body>
</html>