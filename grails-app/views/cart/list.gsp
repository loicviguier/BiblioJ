
<%@ page import="biblioj.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-livre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" />
						
						<th>Statut</th>
						
						<th>Panier</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${livreInstanceList}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "titre")}</g:link></td>
						
						<g:if test="${livreInstance.nombreExemplairesDisponibles > 0}">
							<td>Disponible</td>
						</g:if><g:else>
							<td>Indisponible</td>
						</g:else>
						
						<td>
							<g:link class="buttons" style="text-decoration: none; color: black;" controller="cart" action="remove" id="${i}"> Retirer </g:link>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<fieldset class="buttons">
				<g:actionSubmit class="save" controller="cart" action="save" value="Save"/>
			</fieldset>
		</div>
	</body>
</html>
