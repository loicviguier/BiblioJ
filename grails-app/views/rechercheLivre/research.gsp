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
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="Retour a l'acceuil"/></a></li>
				<li><a class="list" href="${createLink(uri: '/livre/index')}"> Retour à la liste de livre </a></li>
			</ul>
		</div>
		<div id="research-livre" class="content" role="main">
			<h1>Recherche de Livre</h1>
			
			<g:form controller="livre" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="formulaireBoutonSubmit" action="list" value="Submit" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>