<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body>
    <center>
    	<jsp:include page="top.jsp"></jsp:include>
		<div id="managePage">
			<div id="manageLeft">
				<jsp:include page="manageLeft.jsp"></jsp:include>
			</div>
			<div id="manageBook" >
			<s:action name="singleBookAction" executeResult="false"></s:action>
				<ul class="singleBookUl" >
					<li class="singleBookName" >
						<s:property value="#request.singleBook.bookName"/>
					</li>
					<li class="singleBookPicture">
						<img src='../upload/<s:property value="#request.singleBook.bookPicture"/>' />
					</li>
					<li class="singleBookInfor">
						作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="#request.singleBook.bookAuthor"/>"><s:property value="#request.singleBook.bookAuthor"/></a><br/>
						出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="#request.singleBook.bookPress"/>"><s:property value="#request.singleBook.bookPress"/></a><br/>
						类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="#request.singleBook.type.typeId"/>"><s:property value="#request.singleBook.type.typeName"/></a><br/>
						上架时间：<s:date name="#request.singleBook.bookShelveTime" format="yyyy-MM-dd HH:mm:ss"/><br/>
						图书简介：<s:property value="#request.singleBook.bookRemark"/><br/>
						原价：<font style="text-decoration: line-through;color:red;"><s:property value="#request.singleBook.bookPrice"/></font> 元&nbsp;&nbsp;&nbsp;&nbsp;现价：<s:property value="#request.singleBook.bookNewPrice"/> 元<br/>
						<a class="bookName" href='updateBook.jsp?bookId=<s:property value="#request.singleBook.bookId"/>'>修改图书信息</a>
					</li>
				</ul>
			</div>
		</div>
    </center>
  </body>
