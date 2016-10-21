<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body>
    <center>
    	<jsp:include page="top.jsp"></jsp:include>
		<div id="managePage" style="height: 630px;background-color: white;">
			<div id="manageLeft" >
				<jsp:include page="manageLeft.jsp"></jsp:include>
			</div>	
			<div id="oneType" >
			<s:action name="oneTypeAction" executeResult="false"></s:action>
	    		<ul class="allBookUl" >
	    			<li class="allBookHead" >
	    				<s:property value="#request.typeDescribe"/>
	    			</li>
					<s:iterator value="#request.bookList" status="st">
						<li class="allBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookid" />"><img src='<%=basePath%>upload/<s:property value="bookPicture" />'/></a><!-- 用jsp代码取得绝对地址 -->
						</li>
						<li class="allBookInfor" style="width: 200px;">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookId" />"><s:property value="bookName" /></a><br/><br/>
							作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
							出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
							类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="booktype.typeId"/>"><s:property value="booktype.typeName"/></a><br/><br/>
						</li>
					</s:iterator>
	    		</ul>
	    	</div>	
		</div>
    </center>
  </body>
