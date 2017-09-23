<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="page-wrapper">
	<div class="row">
		<h1>Account Edit</h1>

		<form:form modelAttribute="account" action="${pageContext.request.contextPath}/dashboard/account/${submitPath}/submit">
			<div class="form-group">
				<label for="account-name">Account name</label>
				<form:input
					path="accountName" id="account-name" class="form-control" type="text"
					value="${account.accountName}"/>
				<form:errors path="accountName" cssClass="has-error"></form:errors>
			</div>
			<div class="form-group">
				<label for="balance.startAmountStr">Balance</label>
				<form:input path="balance.startAmountStr" id="balance.startAmountStr" readonly="${isEdit}"
					cssClass="form-control" type="text" value="${account.balance.startAmountStr}" />
			</div>
			<div class="form-group">
				<label for="currency.encryptedId">Currency</label>
				<form:select path="currency.encryptedId" items="${currencyList}" cssClass="form-control" disabled="${isEdit}"></form:select>
				<form:errors path="currency.encryptedId" cssClass="has-error"></form:errors>
			</div>
			<div class="form-group">
				<form:hidden path="lastModifiedStr" value="${account.lastModifiedStr}" cssClass="form-control" />
			</div>
			<input name="submit" type="submit" value="${saveBtn}"
				class="btn btn-lg btn-primary" />
			<a href="${pageContext.request.contextPath}/dashboard/account/"
				class="btn btn-lg btn-default">${cancelBtn}</a>
		</form:form>
	</div>
</div>