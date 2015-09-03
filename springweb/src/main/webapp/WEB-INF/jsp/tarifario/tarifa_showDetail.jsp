<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<commons:headerUser id="login" />

<!-- Main -->
<div class="container-fluid">
    <div class="row">
		<div class="col-sm-12">
			<div class="row">		
				<div class="table-responsive">
				<table class="table table-striped" >
				<thead>
				<tr>	
					<th>Dato</th>	
					<th>Valor</th>
				</tr>
				</thead>	
				<tbody id='tbody'>
					<tr>			
						<td>Ruta</td>
						<td>${attributeRutaspricehistory.ruta.description}</td>					
					</tr>
					<tr>			
						<td>Costo Combustible</td>
						<td>${attributeRutaspricehistorydetail.fuel}</td>					
					</tr>	
					<tr>			
						<td>mttokm(Variable)</td>
						<td>${attributeRutaspricehistorydetail.mttokm}</td>					
					</tr>
					<tr>			
						<td>Back Up Mexico</td>
						<td>${attributeRutaspricehistorydetail.backupmexico}</td>					
					</tr>	
					<tr>			
						<td>FEE</td>
						<td>${attributeRutaspricehistorydetail.fee}</td>					
					</tr>	
					<tr>			
						<td>Jornada Laboral Foraneo</td>
						<td>${attributeRutaspricehistorydetail.foreingworkday}</td>					
					</tr>
					<tr>			
						<td>Jornada Laboral Local</td>
						<td>${attributeRutaspricehistorydetail.localworkday}</td>					
					</tr>	
					<tr>			
						<td>Viajes</td>
						<td>${attributeRutaspricehistorydetail.travels}</td>					
					</tr>
					<tr>			
						<td>Km/viaje</td>
						<td>${attributeRutaspricehistorydetail.kmtravel}</td>					
					</tr>	
					<tr>			
						<td>Tiempo de ciclo</td>
						<td>${attributeRutaspricehistorydetail.cycletyme}</td>					
					</tr>	
					<tr>			
						<td>Tiempo de ciclo ayudante</td>
						<td>${attributeRutaspricehistorydetail.cycletimeassistant}</td>					
					</tr>
					<tr>			
						<td>Rendimiento(Its/km)</td>
						<td>${attributeRutaspricehistorydetail.yielditskm}</td>					
					</tr>	
					<tr>			
						<td>Ayudantes por viaje</td>
						<td>${attributeRutaspricehistorydetail.assistanttravel}</td>					
					</tr>	
					<tr>			
						<td>Sueldo Promedio Operador</td>
						<td>${attributeRutaspricehistorydetail.avgsalaryoperator}</td>					
					</tr>
					<tr>			
						<td>Sueldo Promedio Ayudante</td>
						<td>${attributeRutaspricehistorydetail.avgsalaryassistant}</td>					
					</tr>
					<tr>			
						<td>Pasivo Labora Operador</td>
						<td>${attributeRutaspricehistorydetail.pasivelaboroperator}</td>					
					</tr>
					<tr>			
						<td>Pasivo Labora Ayudante</td>
						<td>${attributeRutaspricehistorydetail.pasivelaborassistant}</td>					
					</tr>
					<tr>			
						<td>Mano de obra</td>
						<td>${attributeRutaspricehistorydetail.totalworkforce}</td>					
					</tr>
					<tr>			
						<td>Combustible</td>
						<td>${attributeRutaspricehistorydetail.totalfuel}</td>					
					</tr>
					<tr>			
						<td>Mtto</td>
						<td>${attributeRutaspricehistorydetail.totalmtto}</td>					
					</tr>
					<tr>			
						<td>Gastos de viaje</td>
						<td>${attributeRutaspricehistorydetail.totalexpensestravel}</td>					
					</tr>
					<tr>			
						<td>Incremento mano de obra</td>
						<td>${attributeRutaspricehistorydetail.incrementtotalworkforce}</td>					
					</tr>
					<tr>			
						<td>Incremento combustible</td>
						<td>${attributeRutaspricehistorydetail.incrementtotalfuel}</td>					
					</tr>
					<tr>			
						<td>Incremento mtto</td>
						<td>${attributeRutaspricehistorydetail.incrementtotalmtto}</td>					
					</tr>
					<tr>			
						<td>Incremento gastos de viaje</td>
						<td>${attributeRutaspricehistorydetail.incrementtotalexpensestravel}</td>					
					</tr>
					<tr>			
						<td><strong>Precio</strong></td>
						<td><strong>${attributeRutaspricehistory.price}</strong></td>					
					</tr>																																																																																																												
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