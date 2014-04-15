package biblioj

class RechercheLivreController {

   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        render(view: "research")
    }
	
	def list(Integer max) {
		params.max = Math.min(max ?: 5, 100)
		[livreInstanceList: Livre.list(params), livreInstanceTotal: Livre.count()]
		render(view: "list")
	}
	

	def research (String champRechercheTitreLivre, String champRechercheAuteurLivre, TypeDocument champRechercheTypeLivre) {
		String titre = params.champRechercheTitreLivre
		String auteur = params.champRechercheAuteurLivre
		String type = params.champRechercheTypeLivre
		
		System.out.println ('titre : ' + champRechercheTitreLivre + '/ Auteur :' + champRechercheAuteurLivre + '/ Type : ' + champRechercheTypeLivre)
		
		def listeLivre = Livre.list()
		
		if(titre != null) {
			listeLivre = listeLivre.findAll("from Livre as l where l.titre like %?%", [titre])
		} 
		if(listeLivre != null) {
			if(auteur != null) {
				listeLivre = listeLivre.findAll("from Livre as l where l.auteurs like %?%", [auteur])
			}
		} else if(auteur != null){
			listeLivre = Livre.list()
			listeLivre = listeLivre.findAll("from Livre as l where l.auteurs like %?%", [auteur])
		}
		if(listeLivre != null) {
			if(type != null) {
				listeLivre = listeLivre.findAll("from Livre as l where l.type like %?%", [type])
			}
		} else if(auteur != null){
			listeLivre = Livre.list()
			listeLivre = listeLivre.findAll("from Livre as l where l.type like %?%", [type])
		}
		
		redirect('list')
	}
}
