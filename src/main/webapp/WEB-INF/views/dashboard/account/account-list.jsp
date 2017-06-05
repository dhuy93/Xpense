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
				</div>
			
		</div>
	</div>
</body>
</html>