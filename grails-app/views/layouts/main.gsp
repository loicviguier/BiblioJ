<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'Logo-BnF.png')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'Logo-BnF.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'Logo-BnF.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<div id="panier">
			<div id="titrePanier">Le panier :</div>
			<div id="contenuPanier">
				<g:if test="${session.getAttribute("cart") != null}">
				<g:if test="${session.getAttribute("cart").size() > 0}">
					<table>
						<g:each in="${session.getAttribute("cart")}" status="i" var="livre">
							<tr>
								<td>${fieldValue(bean: livre, field: "titre")}</td>
								<td>
									<g:link class="buttons" style="text-decoration: none; color: black;" controller="cart" action="remove" id="${i}"> Retirer </g:link>
								</td>
							</tr>
						</g:each>
					</table>
				</g:if>
				<g:else>
					<table>
						<tr>
							<td> Votre panier est vide </td>
						</tr>
					</table>
				</g:else>
				</g:if>
				<g:link class="buttons" controller="reservation" action="add" id = "${session.getAttribute("idReservation")}">Valider le panier</g:link>
			</div>
		</div>
	
	
	
		<div id="grailsLogo" role="banner"><img src="${resource(dir: 'images', file: 'Logo-BnF.png')}" alt="Grails" width="100" height="100"/>Bibliothèque nationale de France</div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
		
	</body>
</html>
