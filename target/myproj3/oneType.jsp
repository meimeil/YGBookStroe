<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询</title>
</head>
<body>
<center>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="oneType">
			<div id="left">
				<jsp:include page="Left.jsp"></jsp:include>
			</div>
		
			<s:action name="oneTypeAction" executeResult="false"></s:action>
				<div id="allBook" >
	    		<ul class="allBookUl">
	    			<li class="allBookHead">
	    				<s:property value="#request.typeDescribe"/>
	    			</li>
				<s:iterator value="#attr.bookList" status="st">
					
					<li class="allBookPicture">
						<img src='upload/<s:property value="bookPicture"/>' />
					</li>
					<li class="allBookInfor" style="padding-bottom:60px">
					<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookid" />"><s:property value="bookName" /></a><br/><br/>
						作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
						出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
						类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="booktype.typeId"/>"><s:property value="booktype.typeName"/></a><br/><br/>
						<a href='com.shop.beans.action/shoppingCartAction.action?bookId=<s:property value="bookid"/>' style="text-decoration: none;">
						<img alt="放入购物车" src="image/button.jpg">
						</a>
					</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div id="bottom">
		<jsp:include page="bottom.html"></jsp:include>
		</div>
	</center>
</body>
</html>