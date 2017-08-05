<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row">
		<h1>Account List</h1>
		
		<div class="col-lg-8 col-lg-offset-2">
			<div class="table-responsive">
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
						<c:forEach items="${accountList}" var="account" varStatus="loop">
							<tr class="">
								<td>${account.accountName}</td>
								<td>${account.balance.amount}</td>
								<td>${account.currency.name}</td>
								<td>
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="balance${loop.index}" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="balance${loop.index}">
											<li><a href="${pageContext.request.contextPath}/dashboard/account/edit/${account.encryptedId}/${account.currency.encryptedId}">Edit</a></li>
											<li><a href="${pageContext.request.contextPath}/dashboard/account/delete/${account.encryptedId}">Delete</a></li>
										</ul>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


			<!-- Pagination -->
			<nav aria-label="Page navigation" id="pagination">
				<ul class="pagination">
					<li>
						<c:url value="/dashboard/account/" var="prev">
							<c:param name="page" value="${page-1}" />
						</c:url>
						<c:choose>
							<c:when test="${page > 1}">
								<li><a href="<c:out value="${prev}" />" class="pn prev"  aria-label="Previous">Prev</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href="<c:out value="${prev}" />" class="pn prev">Prev</a></li>
							</c:otherwise>
						</c:choose>
					</li>
					<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
						<c:choose>
							<c:when test="${page == i.index}">
								<li class="active"><a href="#">${i.index}<span class="sr-only">(current)</span></a></li>
							</c:when>
							<c:otherwise>
								<li>
									<c:url value="/dashboard/account/" var="url">
										<c:param name="page" value="${i.index}" />
									</c:url>
									<a href='<c:out value="${url}" />'>${i.index}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li>
						<c:url value="/dashboard/account/" var="next">
							<c:param name="page" value="${page + 1}" />
						</c:url>
						<c:choose>
							<c:when test="${page + 1 <= maxPages}">
								<li><a href='<c:out value="${next}" />' class="pn next">Next</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href='<c:out value="${next}" />' class="pn next">Next</a></li>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</div>