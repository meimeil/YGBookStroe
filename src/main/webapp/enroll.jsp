<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
<!-- form提交后,将在struts.xml中寻找enrollAction所表示的Action文件 -->
<s:form action="enrollAction">
<s:textfield class= "user" label="用户名"  name="userName"> </s:textfield>
<s:password label="密码" name="userPassword"></s:password>
<s:password label="重复密码" name="userRePassword"></s:password>
<s:textfield label="邮箱"  name="userEmail"> </s:textfield>
<s:submit value="注册"></s:submit>
	</s:form>
</body>
</html>