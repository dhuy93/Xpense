<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Account List</h1>
			
			<div class="col-lg-8 col-lg-offset-2">
				<table class="table table-hover">
					<thead>
						<tr>
							<th width="60%">Name</th>
							<th width="30%">Balance</th>
							<th width="10%">Currency</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${accountList}" var="account">
							<tr class="">
								<td>${account.accountName}</td>
								<td>${account.balance.amount}</td>
								<td>${account.currency.name}</td>
								<td>
									<a href="#">
										<span class="glyphicon glyphicon-option-horizontal" style="border: 1px solid black; border-radius: 2px;font-size: 20px;"></span>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div id="pagination">
					<c:url value="/dashboard/account/" var="prev">
						<c:param name="page" value="${page-1}" />
					</c:url>
					<c:if test="${page > 1}">
						<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
					</c:if>

					<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
						<c:choose>
							<c:when test="${page == i.index}">
								<span>${i.index}</span>
							</c:when>
							<c:otherwise>
								<c:url value="/dashboard/account/" var="url">
									<c:param name="page" value="${i.index}" />
								</c:url>
								<a href='<c:out value="${url}" />'>${i.index}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:url value="/dashboard/account/" var="next">
						<c:param name="page" value="${page + 1}" />
					</c:url>
					<c:if test="${page + 1 <= maxPages}">
						<a href='<c:out value="${next}" />' class="pn next">Next</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>