package biblioj

class RechercheLivreController {

   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        render(view: "research")
    }
	

	def research () {
		String titre = params.champRechercheTitreLivre
		String auteur = params.champRechercheAuteurLivre
		String type = params.champRechercheTypeLivre
	// Dispatcher en fonction des params recu
		
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
	}
}
