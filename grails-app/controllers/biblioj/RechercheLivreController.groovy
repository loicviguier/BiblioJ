package biblioj

class RechercheLivreController {

   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        render(view: "research")
    }
	
	// Dispatcher en fonction des params recu
	def research() {
		
	}
	
	def rechercheLivreParTitre (paramTitreLivre) {
		
	}
	
	def rechercheLivreParAuteur (paramAuteurLivre) {
		
	}
	
	def rechercheLivreParType (paramTitreLivre) {
		
	}
}
