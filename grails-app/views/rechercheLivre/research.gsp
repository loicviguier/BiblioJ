<%@ page import="biblioj.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Recherche de Livre</title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="research-livre" class="content" role="main">
			<h1>Recherche de Livre</h1>
			
			<g:if test="${titreInstance==""}">
				<ul class="errors" role="alert">
					<li> Champ de recherche par titre vide! </li>
				</ul>
			</g:if>
			
			<g:form method="post" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="formulaireBoutonSubmit" action="research" value="Submit" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>