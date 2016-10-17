<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阳光书屋</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<center>

		<jsp:include page="top.jsp"></jsp:include>
		
		<div id="firstPage">
			<div id="left">
				<jsp:include page="Left.jsp"></jsp:include>
			</div>	
			<div id="allBook">
				<jsp:include page="allBook.jsp"></jsp:include>
			</div>		
		</div>
		<div id="buttom"><jsp:include page="bottom.html"></jsp:include></div>
		
  	</center>
</body>
</html>