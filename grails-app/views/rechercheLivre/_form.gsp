	
<label for="champRechercheTitreLivre"> Titre <span class="required-indicator">*</span></label>
<g:textField name="champRechercheTitreLivre" required="required" value="" />

<label for="champRechercheAuteurLivre"> Auteur </label>
<g:textField name="champRechercheAuteurLivre" required="required" value="" />

<label for="champRechercheTypeLivre"> Type </label>
<g:select id="type" name="type.id" from="${biblioj.TypeDocument.list()}" optionKey="id" required="" value="${livreInstance?.type?.id}" class="many-to-one"/>
	
