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
		<jsp:include page="top.jsp"></jsp:include>
		<div id="singleBook">
			<div id="left">
				<jsp:include page="Left.jsp"></jsp:include>
			</div>
			<div id="bookInfor">
			<s:action name="singleBookAction" executeResult="false"></s:action>
				<ul class="singleBookUl">
					<li class="singleBookName">
						<s:property value="#request.singleBook.bookName"/>
					</li>
					<li class="singleBookPicture">
						<img src='upload/<s:property value="#request.singleBook.bookPicture"/>' />
					</li>
					<li class="singleBookInfor">
						作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="#request.singleBook.bookAuthor"/>"><s:property value="#request.singleBook.bookAuthor"/></a><br/><br/>
						出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="#request.singleBook.bookPress"/>"><s:property value="#request.singleBook.bookPress"/></a><br/><br/>
						类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="#request.singleBook.type.typeId"/>"><s:property value="#request.singleBook.type.typeName"/></a><br/><br/>
						上架时间：<s:date name="#request.singleBook.bookShelveTime" format="yyyy-MM-dd HH:mm:ss"/><br/><br/>
						图书简介：<s:property value="#request.singleBook.bookRemark"/><br/><br/>
						原价：<font style="text-decoration: line-through;color:red;"><s:property value="#request.singleBook.bookPrice"/></font> 元&nbsp;&nbsp;&nbsp;&nbsp;现价：<s:property value="#request.singleBook.bookNewPrice"/> 元<br/><br/><br/><br/>
						<a href='com.shop.beans.action/shoppingCartAction.action?bookid=<s:property value="#request.singleBook.bookId"/>' style="text-decoration: none;">
						<img alt="放入购物车" src="image/button.jpg">
						</a>
					</li>
				</ul>
			</div>
		</div>
		<jsp:include page="bottom.html"></jsp:include>
	</center>
</body>
</html>