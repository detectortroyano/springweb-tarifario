<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<%@attribute name="id" required="false"%>

			<a href="#">
			<strong>
				<i class="glyphicon glyphicon-wrench">
				</i>
				MENU
			</strong>
			</a>
			<hr>
			<ul class="nav nav-stacked">
				<li class="nav-header">
					<a href="#" data-togle="collapse" data-target="#userMenu">
						Tarifario
						<i class="glyphicon glyphicon-chevron-right">
						</i>
					</a>
				</li>
				<ul class="nav nav-staked collapse in" id="userMenu">
				<li class="active">
					<a href="${pageContext.request.contextPath}/tarifario/getTarifas">
						<i class="glyphicon glyphicon-home"></i>Rutas
					</a>
				</li>
				<li>
					<a href="#${pageContext.request.contextPath}/tarifario/getVariables">
						<i class="glyphicon glyphicon-cog"></i>Variables
					</a>
				</li>
				<li>
					<a href="#${pageContext.request.contextPath}/tarifario/getConstantes">
						<i class="glyphicon glyphicon-cog"></i>Constantes
					</a>
				</li>				
				</ul>
			</ul>