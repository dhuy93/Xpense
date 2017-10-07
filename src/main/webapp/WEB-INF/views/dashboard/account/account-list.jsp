<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-10 col-lg-offset-1 col-md-12">
	<div class="heading-text"><h1>${heading}</h1></div>
	<div class="heading-tray">
		<a href="${pageContext.request.contextPath}/dashboard/account/add" class="btn btn-default glyphicon glyphicon-plus">
		</a>
	</div>
</div>
<div class="col-lg-10 col-lg-offset-1 col-md-12">
	<table class="table table-hover table-responsive">
		<thead>
			<tr>
				<th width="60%">${columnName}</th>
				<th width="30%">${columnBalance}</th>
				<th width="10%">${columnCurrency}</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accountList}" var="account" varStatus="loop">
				<tr class="">
					<td>${account.accountName}</td>
					<td>${account.balance.amount}</td>
					<td>${account.currency.currencyName}</td>
					<td>
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="balance${loop.index}" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="true">
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="balance${loop.index}">
								<li><a href="${pageContext.request.contextPath}/dashboard/account/edit/${account.encryptedId}/${account.currency.encryptedId}">${editBtn}</a></li>
								<li><a href="#">${deleteBtn}</a></li>
							</ul>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


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
