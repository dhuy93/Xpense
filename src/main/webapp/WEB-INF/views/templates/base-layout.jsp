<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<tiles:insertAttribute name="lib" ignore="true" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body>
	<div><tiles:insertAttribute name="header" /></div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2" style="top: 51px;"><tiles:insertAttribute name="menu" /></div>  
			<div class="col-sm-9 col-md-10 main" style="top: 71px;">  
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>

	<footer class="footer">
		<div class="container">
			<tiles:insertAttribute name="footer" />
		</div>
	</footer>
</body>
</html>