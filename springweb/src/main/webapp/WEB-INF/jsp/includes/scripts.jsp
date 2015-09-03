<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>

<c:if test="${!jsonUiInRequest}">	 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/ui-lightness/jquery-ui-1.10.3.custom.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/ui/jquery-ui-1.10.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/autocomplete/autocomplete.js"></script>
    
    
	<!-- BOOTSTRAP -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    
	<!-- datatable -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/datatable/js/datatables.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/datatable/js/jquery.dataTables.columnFilter.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/datatable/js/jquery.dataTables.editable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/datatable/js/jquery.jeditable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/datatable/js/jquery.jeditable.elements.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/datatable/css/TableTools.css">   	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/datatable/js/TableTools.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/datatable/css/dataTables.colVis.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/datatable/js/dataTables.colVis.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.validate.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>

	<c:set var="jsonUiInRequest" scope="request" value="true"/>
</c:if>
