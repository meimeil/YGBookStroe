<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改图书</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
<body>
	<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="managePage">
			<div id="manageLeft">
				<jsp:include page="manageLeft.jsp"></jsp:include>
			</div>	
			<div id="addBook" align="center">
			<s:action name="singleBookAction" executeResult="false"></s:action><!-- 加载时就执行 -->
				<h1>修改图书</h1><br/>
				<s:form action="updateBookAction" method="post" enctype="multipart/form-data">
					<s:hidden name="bookId" value="%{#request.singleBook.bookId}"></s:hidden>
					<s:textfield label="名称" name="bookName" value="%{#request.singleBook.bookName}"></s:textfield>
					<s:textfield label="作者" name="bookAuthor" value="%{#request.singleBook.bookAuthor}"></s:textfield>
					<s:textfield label="出版社" name="bookPress" value="%{#request.singleBook.bookPress}"></s:textfield>
					<s:file label="图片" name="doc"></s:file>
					<s:select label="类别" name="typeId" value="%{#request.singleBook.booktype.typeId}" list="#{'1':'数据库','2':'通信','3':'计算机应用','4':'程序设计','5':'计算机网络'}"></s:select>
					<s:textfield label="价格" name="bookPrice" value="%{#request.singleBook.bookPrice}"></s:textfield>
					<s:textfield label="数量" name="bookAmount" value="%{#request.singleBook.bookAmount}"></s:textfield>
					<s:textarea label="简介" name="bookRemark" value="%{#request.singleBook.bookRemark}"></s:textarea>
					<s:submit value="修改"></s:submit>
				</s:form>
			</div>
		</div>
	</center>
</body>
</html>
