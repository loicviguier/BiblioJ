<div class="fieldcontain">
	<label for="champRechercheTitreLivre"> Titre <span
		class="required-indicator">*</span></label>
	<g:textField name="champRechercheTitreLivre" required=""
		value="" />
</div>

<div class="fieldcontain">
	<label for="champRechercheAuteurLivre"> Auteur </label>
	<g:textField name="champRechercheAuteurLivre" value="" />
</div>

<div class="fieldcontain">
	<label for="champRechercheTypeLivre"> Type </label>
	<g:select id="type" name="champRechercheTypeLivre"
		from="${biblioj.TypeDocument.list()}" optionKey="id"
		value="${livreInstance?.type?.id}" class="many-to-one"
		noSelection="['null':'- Choose a type -']" />
</div>
