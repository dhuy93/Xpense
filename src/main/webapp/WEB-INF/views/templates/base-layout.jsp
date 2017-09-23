<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<tiles:insertAttribute name="lib" ignore="true" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<!-- HEADER -->
			<tiles:insertAttribute name="header" />
		
			<!-- SIDE MENU -->
			<tiles:insertAttribute name="menu" />
		</nav>
	
		<!-- BODY -->
		<tiles:insertAttribute name="body" />
	</div>

	<footer class="footer">
		<div class="container">
			<tiles:insertAttribute name="footer" />
		</div>
	</footer>
</body>
</html>