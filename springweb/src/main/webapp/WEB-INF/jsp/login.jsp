<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<commons:headerPublic id="login" />

	<div id="login-container">
	    <div id="login-box">
	        <div>
	            	<c:if test="${error == true}">
						<b class="error">Usuario o contrase&ntildea Invalidos.</b>
					</c:if>
					</p>            
	                <form id="loginForm" name="loginForm" method="post" action="<c:url value='j_spring_security_check'/>" >
	                    <table align="center">
	                    <tbody>
	                    <tr>
	                        <td>Usuario</td>
	                        <td><input class="input" type="text" name="j_username" id="j_username"size="30" maxlength="40"  /></td>
	                    </tr>
	                    <tr>
	                        <td>Contrase&ntildea</td>
	                        <td><input class="input" type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
	                    </tr>
	                    <tr>
	                    	<td></td>
	                    	<td class="buttons"><input name="submit" class="form-button" type="submit" value="Aceptar" /></td>
	                    </tr>                    
	                    </tbody>
	                    </table>
	                </form> 
	                <br/>
	                <a href="${pageContext.request.contextPath}/recoverPassword">¿Olvido su contrase&ntildea?</a>	                                   
		            <script type="text/javascript">
		                $(document).ready(
		                    function() {
		                        $("#loginForm #j_username").focus();
		                    }
		                );
		            </script>
	        </div>
	    </div>
	</div>

<commons:footer />