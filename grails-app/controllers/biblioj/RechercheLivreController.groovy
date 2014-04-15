package biblioj

class RechercheLivreController {

   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
	
	def rechercheLivreParTitre (paramTitreLivre) {
		
	}
	
	def rechercheLivreParAuteur (paramAuteurLivre) {
		
	}
	
	def rechercheLivreParType (paramTitreLivre) {
		
	}
}
