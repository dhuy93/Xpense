<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row">
		<form action="#">
			<div class="form-group">
				<label for="account-name">Account name</label>
				<input id="account-name" class="form-control" type="text" value="${account.accountName}">
			</div>
			<div class="form-group">
				<label for="account-name">Balance</label>
				<input id="account-name" class="form-control" type="text" value="${account.balance.amount}">
			</div>
			<div class="form-group">
				<label for="account-name">Currency</label>
				<input id="account-name" class="form-control" type="text" value="${account.currency.name}">
			</div>
		</form>
	</div>
</div>