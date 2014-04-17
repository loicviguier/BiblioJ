package biblioj

class RechercheLivreController {

   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

   
    def index() {
        render(view: "research")
    }
	
	def list(Integer max) {
		// TODO : Faire passer une liste d'objet Livre dans livreInstanceList
		
		RechercheLivreService livreResultantList = new RechercheLivreService()
		
		params.max = Math.min(max ?: 5, 100)
		livreResultantList.rechercheLivre(params)
		render(view: "list")
	}

}
