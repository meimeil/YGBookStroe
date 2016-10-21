<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆页</title>
<style type="text/css">
		.tdLabel{
			width:100px;
			font-size: 14px;
			font-weight: bold;
		}
		.login_input{
			width: 200px;
			height: 25px;
			border-color: #FF6600;
			border-style: solid;
			border-width: 1px;
			list-style: none;
		}
		.login{
			background-image: url(image/login_button.jpg);
			width:86px;
			height: 27px;
			background-color: Transparent;
			border-style: none;
		}
		.wwFormTable{
			line-height: 30px;
		}
	</style>
</head>
<body>
<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div style="margin-top: 10px;width: 900px;height: 30px;background-color: #FF6600;" align="left"><div style="font-size: 14px;font-weight: bold;color:white;position: relative;margin-top:5px;margin-left:10px;">用户登录</div></div>
		<div id="login" style="margin-top: 0px;width:898px;border: 1px #FF6600;border-style: solid;">
			<s:form action="loginAction">
				<s:textfield label="用户" name="userName" cssClass="login_input"></s:textfield>
				<s:password label="密码" name="userPassword" cssClass="login_input"></s:password>
				<s:submit type="submit" value=" " cssClass="login" align="center"></s:submit>
			</s:form>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
</html>