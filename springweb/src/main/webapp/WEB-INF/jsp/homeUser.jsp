<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<commons:headerUser id="login" />

<!-- Main -->
<div class="container-fluid">
    <div class="row">
		<div class="col-sm-3">
			<commons:menu id="login" />
		</div>
		<div class="col-sm-9">
			<h1><spring:message code="label.home.title"/></h1>
			<h2><spring:message code="label.home.user.title"/></h2>
		</div>
    </div>
</div>
<!-- /Main -->	
<commons:footer />