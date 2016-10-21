<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type="text/css">
		.wwFormTable{/* struts为form自动生产的模版标签table名  */
			
			
		}
		.errorMessage{
			color:red;
			position: absolute;
			margin-left: 130px;
			margin-top: 5px;
		}
	</style>
</head>
<body>
<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="managePage" style="width: 100%;height: 630px;background-color: white;">
			<div id="manageLeft">
				<jsp:include page="manageLeft.jsp"></jsp:include>
			</div>	
			<div style="background-color: yellow;width:90%;height:30px;text-align: left;">添加新书</div>
			<div id="addBook"  align="center">

				<s:form action="bookAction" method="post" enctype="multipart/form-data">
					<s:textfield label="名称" name="bookName"></s:textfield>
					<s:textfield label="作者" name="bookAuthor"></s:textfield>
					<s:textfield label="出版社" name="bookPress"></s:textfield>
					<s:file label="图片" name="doc"></s:file>
					<s:select label="类别" name="typeId" list="#{'1':'数据库','2':'通信','3':'计算机应用','4':'程序设计','5':'计算机网络'}"></s:select>
					<s:textfield label="价格" name="bookPrice"></s:textfield>
					<s:textfield label="数量" name="bookAmount"></s:textfield>
					<s:textarea label="简介" name="bookRemark"></s:textarea>
					<s:submit value="添加"></s:submit>
				</s:form>
			</div>
		</div>
		
	</center>
</body>
</html>