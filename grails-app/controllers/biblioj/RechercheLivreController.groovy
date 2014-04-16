package biblioj

class RechercheLivreController {

   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        render(view: "research")
    }
	
	def list(Integer max) {
		// TODO : Faire passer une liste d'objet Livre dans livreInstanceList
		def livreResultantList = params.livreResultantList
		int tailleLivreResultantList = livreResultantList.size()
		
		System.out.println (params.livreResultantList)
		
		params.max = Math.min(max ?: 5, 100)
		[livreInstanceList: livreResultantList, livreInstanceTotal: tailleLivreResultantList ]
		render(view: "list")
	}
	

	def research () {
		
		String titreRecherche = params.champRechercheTitreLivre
		String auteurRecherche = params.champRechercheAuteurLivre
		String typeRecherche = params.champRechercheTypeLivre
		
		if (!titreRecherche) {
			render(view: "research", model: [titreInstance: titreRecherche])
			return
		}
		
		System.out.println (' - Titre : ' + titreRecherche + '\n - Auteur :' + auteurRecherche + '\n - Type : ' + typeRecherche)
		
		// TODO : Recherche par bout de titre
		def livreResultantList = Livre.findAllByTitre(titreRecherche)
		
		System.out.println (livreResultantList)
		
		// Affinement de la recherche par Auteur
		if(auteurRecherche != "") {
			livreResultantList = livreResultantList.findAll("FROM Livre AS l WHERE l.auteurs like %?%", [auteurRecherche])
		} 
		
		// Affinement de la recherche par Type
		if(typeRecherche != "") {
			livreResultantList = livreResultantList.findAll("FROM Livre AS l WHERE l.type like %?%", [typeRecherche])
		}
		
		// TODO : Envoyer une liste d'objet Livre en params
		redirect(action: "list", params: [livreResultantList: livreResultantList])
	}
}
