<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
	    	<div id="manageBook">
		    	<s:action name="allBookAction" executeResult="false"></s:action>
	    		<ul class="manageBookUl" >
	    			<li class="manageBookHead"  >
	    				最新上架<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=latest">更多..</a>
	    			</li>
					<s:iterator value="#attr.latestBook" status="st">
						<li class="manageBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookid" />"><img src='../upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="manageBookInfor">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookid" />"><s:property value="bookName" /></a><br/><br/>
							作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
							出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
							类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="booktype.typeId"/>"><s:property value="booktype.typeName"/></a><br/><br/>
						</li>
					</s:iterator>
	    		</ul>
	    		<ul class="manageBookUl" >
	    			<li class="manageBookHead" >
	    				特价热销<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=bargain">更多..</a>
	    			</li>
					<s:iterator value="#attr.bargainBook" status="st">
						<li class="manageBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookid" />"><img src='../upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="manageBookInfor">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookid" />"><s:property value="bookName" /></a><br/><br/>
							作者：<a class="aboutBook" href="oneType.jsp?searchType=bookAuthor&searchDescribe=<s:property value="bookAuthor"/>"><s:property value="bookAuthor"/></a><br/><br/>
							出版社：<a class="aboutBook" href="oneType.jsp?searchType=bookPress&searchDescribe=<s:property value="bookPress"/>"><s:property value="bookPress"/></a><br/><br/>
							类别：<a class="aboutBook" href="oneType.jsp?searchType=bookType&searchDescribe=<s:property value="booktype.typeId"/>"><s:property value="booktype.typeName"/></a><br/><br/>
						</li>
					</s:iterator>
	    		</ul>
	    		<ul class="manageBookUl" >
	    			<li class="manageBookHead" >
	    				精品推荐<a class="more" href="oneType.jsp?searchType=bookStatus&searchDescribe=recommended">更多..</a>
	    			</li>
					<s:iterator value="#attr.recommendedBook" status="st">
						<li class="manageBookPicture">
							<a href="singleBook.jsp?bookId=<s:property value="bookid" />"><img src='../upload/<s:property value="bookPicture" />'/></a>
						</li>
						<li class="manageBookInfor">
							<a class="bookName" href="singleBook.jsp?bookId=<s:property value="bookid" />"><s:property value="bookName" /></a><br/><br/>
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
</html>