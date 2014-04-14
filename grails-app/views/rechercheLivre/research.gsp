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
			<g:form name="formulaireRechercheLivre" url="[controller:'RechercheLivreController', action:'research']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="formulaireBoutonSubmit" value="Submit" action="update" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>