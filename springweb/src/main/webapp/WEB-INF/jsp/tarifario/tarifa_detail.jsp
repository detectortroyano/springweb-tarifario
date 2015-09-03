<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<commons:headerUser id="login" />

	<form:form method="post" action="${pageContext.request.contextPath}/tarifario/editTarifaPost" commandName="rutaspricehistory" >
	<input type="hidden" name="id" value="${attributeRutaspricehistory.id}"/>
	<input type="hidden" name="ruta.id" value="${attributeRutaspricehistory.ruta.id}"/>
	<div id="myModal" class="modal">
	<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
	    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    	<h3 id="myModalLabel">Ruta</h3>
	  	</div>
	  	<div class="modal-body">
									<div class="control-group">
					                                <label class="control-label">Ruta</label>
					                                <div class="controls">                                
					                                <form:input path="ruta.description" id="ruta" value="${attributeRutaspricehistory.ruta.description}" class="form-control" />				                                
					                                </div>			                                
					                </div> 	
					                <hr>						                	
									<div class="control-group">
					                                <label class="control-label">Costo Combustible</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.fuel" value="${attributeRutaspricehistorydetail.fuel}" class="form-control" />				                                
					                                </div>
					                </div> 	
									<div class="control-group">
					                                <label class="control-label">mmto/km(Variable)</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.mttokm" value="${attributeRutaspricehistorydetail.mttokm}" class="form-control" />				                                
					                                </div>
					                </div> 	
									<div class="control-group">
					                                <label class="control-label">Back Up Mexico</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.backupmexico" value="${attributeRutaspricehistorydetail.backupmexico}" class="form-control" />				                                
					                                </div>
					                </div> 	
									<div class="control-group">
					                                <label class="control-label">FEE</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.fee" value="${attributeRutaspricehistorydetail.fee}" class="form-control" />				                                
					                                </div>
					                </div> 
									<div class="control-group">
					                                <label class="control-label">Jornada Laboral Foraneo</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.foreingworkday" value="${attributeRutaspricehistorydetail.foreingworkday}" class="form-control" />				                                
					                                </div>
					                </div>	
									<div class="control-group">
					                                <label class="control-label">Jornada Laboral Local</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.localworkday" value="${attributeRutaspricehistorydetail.localworkday}" class="form-control" />				                                
					                                </div>
					                </div>	
					                <hr>
									<div class="control-group">
					                                <label class="control-label">Viajes</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.travels" value="${attributeRutaspricehistorydetail.travels}" class="form-control" />				                                
					                                </div>
					                </div>
									<div class="control-group">
					                                <label class="control-label">Km/viaje</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.kmtravel" value="${attributeRutaspricehistorydetail.kmtravel}" class="form-control" />				                                
					                                </div>
					                </div>	
									<div class="control-group">
					                                <label class="control-label">Tiempo de ciclo</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.cycletyme" value="${attributeRutaspricehistorydetail.cycletyme}" class="form-control" />				                                
					                                </div>
					                </div>	
									<div class="control-group">
					                                <label class="control-label">Tiempo de ciclo ayudante</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.cycletimeassistant" value="${attributeRutaspricehistorydetail.cycletimeassistant}" class="form-control" />				                                
					                                </div>
					                </div>					      
									<div class="control-group">
					                                <label class="control-label">Rendimiento(Its/km)</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.yielditskm" value="${attributeRutaspricehistorydetail.yielditskm}" class="form-control" />				                                
					                                </div>
					                </div>					                          					                				                
									<div class="control-group">
					                                <label class="control-label">Ayudantes por viaje</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.assistanttravel" value="${attributeRutaspricehistorydetail.assistanttravel}" class="form-control" />				                                
					                                </div>
					                </div>	
									<div class="control-group">
					                                <label class="control-label">Sueldo Promedio Operador</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.avgsalaryoperator" value="${attributeRutaspricehistorydetail.avgsalaryoperator}" class="form-control" />				                                
					                                </div>
					                </div>
									<div class="control-group">
					                                <label class="control-label">Sueldo Promedio Ayudante</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.avgsalaryassistant" value="${attributeRutaspricehistorydetail.avgsalaryassistant}" class="form-control" />				                                
					                                </div>
					                </div>	
									<div class="control-group">
					                                <label class="control-label">Pasivo Labora Operador</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.pasivelaboroperator" value="${attributeRutaspricehistorydetail.pasivelaboroperator}" class="form-control" />				                                
					                                </div>
					                </div>	
									<div class="control-group">
					                                <label class="control-label">Pasivo Labora Ayudante</label>
					                                <div class="controls">                                
					                                <form:input path="rutaspricehistorydetail.pasivelaborassistant" value="${attributeRutaspricehistorydetail.pasivelaborassistant}" class="form-control" />				                                
					                                </div>
					                </div>	
	  	</div>
	  	<div class="modal-footer">
	    <input type="submit" id="btnInitRoute" value="Aceptar" class="btn btn-default"/>
	    <input type="button" id="btnCancelRoute" value="Cancelar" class="btn btn-default" data-dismiss="modal"/>
		</div>
	</div>
	</div>		
	</div>
	</form:form>

<!-- Main -->
<div class="container-fluid">
    <div class="row">
		<div class="col-sm-3">
			<commons:menu id="login" />
		</div>
		<div class="col-sm-9">	
			<ul class="list-inline pull-right">
				<li>
				<a href="${pageContext.request.contextPath}/tarifario/getVariables">
					<i class="glyphicon glyphicon-cog"></i>Variables
				</a>				
				</li>
				<li>
				<a href="${pageContext.request.contextPath}/tarifario/getConstantes">
					<i class="glyphicon glyphicon-cog"></i>Constantes
				</a>				
				</li>
				<li>
				<a href="#myModal" role="button" class="btn" data-toggle="modal">
				<span class="glyphicon glyphicon-plus-sign"></span>Actualizar ruta
				</a>
				</li>
			</ul>
			<a href="#">
			<strong>
				<i class="glyphicon glyphicon-dashboard"></i>Historial Ruta>${attributeRutaspricehistory.ruta.description}
			</strong>
			</a>						
			<hr>
			<div class="row">		
				<br><br>			
				<div id="divData" style="display:none">
				<table cellpadding='1px' cellspacing='1px' border='0' id='tbl_data' >
				<thead>
				<tr>	
					<th>Descripcion</th>	
					<th>Tarifa</th>
					<th>Fecha</th>	
					<th>Estatus</th>
				</tr>
				</thead>
				<tfoot>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				</tfoot>	
				<tbody id='tbody'>
				<c:if  test="${!empty rutaspricehistoryList}">
				<c:forEach items="${rutaspricehistoryList}" var="rutaspricehistory">
					<tr>			
						<td><a href="#" onclick="showDetail(${rutaspricehistory.id})">${rutaspricehistory.ruta.description}</a></td>
						<td>${rutaspricehistory.price}</td>
						<td>${rutaspricehistory.datemodified}</td>
						<td>
							<c:choose>
							<c:when test="${ rutaspricehistory.idestatus eq 1 }">ACTIVO</c:when>				
							<c:otherwise>CANCELADO</c:otherwise>
							</c:choose>							
						</td>						
					</tr>
				</c:forEach>
				</c:if>
				</tbody>
				</table>
				</div>
				<br><br>			
			</div>					
		</div>
    </div>
</div>
<!-- /Main -->	

<script type="text/javascript" src="${pageContext.request.contextPath}/js/tarifario/tarifas.js"></script>
<commons:footer />