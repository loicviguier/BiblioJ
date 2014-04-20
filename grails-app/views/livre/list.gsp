
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
				<li><a class="list" href="${createLink(uri: '/livre/research')}">Recherche</a></li>
			</ul>
		</div>
		
			<g:form controller="livre" >
					<span>
					<label for="champRechercheTitreLivre"> Titre</label>
					<g:textField name="champRechercheTitreLivre"
					value="" />
					</span>
					
					<span>
					<label for="champRechercheAuteurLivre"> Auteur </label>
					<g:textField name="champRechercheAuteurLivre" value="" />
					</span>
					
					<span>
						<label for="champRechercheTypeLivre"> Type </label>
						<g:select id="type" name="champRechercheTypeLivre"
							from="${biblioj.TypeDocument.list()}"
							noSelection="['':'- Choose a type -']" />
					</span>
				<fieldset class="buttons">
					<g:actionSubmit class="formulaireBoutonSubmit" action="list" value="Submit" />
				</fieldset>
			</g:form>
			
			<div id="list-livre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" />
					
						<g:sortableColumn property="nombreExemplaires" title="${message(code: 'livre.nombreExemplaires.label', default: 'Nombre Exemplaires')}" />
					
						<g:sortableColumn property="nombreExemplairesDisponibles" title="${message(code: 'livre.nombreExemplairesDisponibles.label', default: 'Nombre Exemplaires Disponibles')}" />
					
						<th><g:message code="livre.type.label" default="Type" /></th>
						
						<th>Panier</th>
					
					</tr>
				</thead>
				<tbody>
				<% if(!session['cart']){ session['cart'] = [] } %>
				
				<g:each in="${livreInstanceList}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "titre")}</g:link></td>
					
						<td>${fieldValue(bean: livreInstance, field: "nombreExemplaires")}</td>
					
						<td>${fieldValue(bean: livreInstance, field: "nombreExemplairesDisponibles")}</td>
					
						<td>${fieldValue(bean: livreInstance, field: "type")}</td>
						
						<td>
							<g:if test="${session['cart'].find { it.id == livreInstance.id }}">Déjà Ajouté</g:if>
							<g:else>
								<g:if test="${livreInstance.nombreExemplairesDisponibles > 0}">
									<g:link class="buttons" style="text-decoration: none; color: black" controller="cart" action="add" id="${livreInstance.id}">Ajouter</g:link></g:if>
								<g:else><p>Indisponible</p></g:else>
							</g:else>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${livreInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
