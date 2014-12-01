<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<%@attribute name="id" required="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title><fmt:message key="console.header.browser.title"/></title>
        <jsp:include page="/WEB-INF/jsp/includes/scripts.jsp" />
        <jsp:include page="/WEB-INF/jsp/includes/css.jsp" />
    </head>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/log-afirme.png"/>
    <body>
    	<div id="page">
    	
        <!--[if IE]><div id="beta" class="ie">Beta</div> <![endif]-->
        <!--[if !IE]><!--> <!-- <div id="beta">  Mario</div>  --><!--<![endif]-->                
        <div id="container">
        <input type="hidden" id="url" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
        <input type="hidden" id="languajeSmall" value="<fmt:message key="label.languaje.small"/>"/>