<div class="fieldcontain">
<label for="champRechercheTitreLivre"> Titre</label>
<g:textField name="champRechercheTitreLivre"
value="" />
</div>

<div class="fieldcontain">
<label for="champRechercheAuteurLivre"> Auteur </label>
<g:textField name="champRechercheAuteurLivre" value="" />
</div>

<div class="fieldcontain">
	<label for="champRechercheTypeLivre"> Type </label>
	<g:select id="type" name="champRechercheTypeLivre"
		from="${biblioj.TypeDocument.list()}"
		noSelection="['':'- Choose a type -']" />
</div>
