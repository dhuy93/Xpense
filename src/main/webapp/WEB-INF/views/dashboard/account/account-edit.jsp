<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h1>${heading}</h1>

<form:form modelAttribute="account" action="${pageContext.request.contextPath}/dashboard/account/${submitPath}/submit">
	<div class="form-group">
		<label for="account-name">${accountNameLabel}</label>
		<form:hidden
			path="accountName" id="account-name" class="form-control"
			value="${account.accountName}"/>
		<form:select path="encryptedId" items="${accountList}" cssClass="form-control js-account-name" ></form:select>
		<form:errors path="encryptedId" cssClass="has-error"></form:errors>
	</div>
	<div class="form-group">
		<label for="balance.startAmountStr">${balanceLabel}</label>
		<form:input path="balance.startAmountStr" id="balance.startAmountStr" readonly="${isEdit}"
			cssClass="form-control" type="text" value="${account.balance.startAmountStr}" />
	</div>
	<div class="form-group">
		<label for="currency.encryptedId">${currencyLabel}</label>
		<form:select path="currency.encryptedId" items="${currencyList}" cssClass="form-control" disabled="${isEdit}"></form:select>
		<form:errors path="currency.encryptedId" cssClass="has-error"></form:errors>
		<form:hidden path="currency.encryptedId" value="${currency.encryptedId}" disabled="${not isEdit}" />
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

<script>
	$(document).ready(function() {
		$(".js-account-name").select2({
			width : '100%',
			tags : true,
			createTag : function(params) {
				console.log(params);
				var term = $.trim(params.term);

				if (term === '') {
					return null;
				}

				$("#account-name").val(term);
				if (${isEdit}) {
					var currentSelection = $(".js-account-name").select2('data')[0];
					$(".js-account-name").val(null).trigger('change');
					currentSelection.text = term;
					return currentSelection;
				} else {
					return {
						id : '' + new Date().getTime(),
						text : term
					}
				}
			}
		});
		$(".js-account-name").on("select2:select", function (e) {
			var accountName = e.params.data.text;
			$("#account-name").val(accountName);
		});
	});
</script>