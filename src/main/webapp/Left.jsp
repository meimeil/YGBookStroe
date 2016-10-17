<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销量排行榜</title>
</head>
<body>

	<s:action name="leftAction" executeResult="false"></s:action> <!-- 访问action文件，立即执行，且不显示执行结果 -->
	<ul class="leftAction" >
		<li class="leftBestSelling">销量排行榜<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=bestSelling">更多</a>
		</li>
		
		<s:iterator value="#request.bestSellingBook"><!-- 获取request对象，名称是点后面的部分 -->
			<li class="leftBookPicture"><a class="bookPicture" href="singleBook.jsp?bookid=<s:property value="bookid"/>">
			<img  src='upload/<s:property value="bookPicture" />'/></a>
			</li>
			
			<li class="leftBookName"><a class="bookName" href="singleBook.jsp?bookid=<s:property value="bookid"/>">
			<s:property value="bookName"/></a>
			</li>
			<li class="leftBookAuthor">作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>">
			<s:property value="bookAuthor"/></a>
			</li>
			<li class="leftBookPress">出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>">
			<s:property value="bookPress"/></a>
			</li>
			<li class="leftBookType">类别：<a class="aboutBook" href="oneType.jsp?searchType=booktype&searchDescribe=<s:property value="booktype"/>">
			<s:property value="booktype.typeName"/></a>
			</li>
			<li><hr/></li>
		</s:iterator>
	</ul>
	
</body>
</html>