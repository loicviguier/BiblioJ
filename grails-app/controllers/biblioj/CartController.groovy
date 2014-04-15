package biblioj

class CartController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { 
		redirect(action: "list", params: params)
	}
	
	def list(){
		params.max = Math.min(max ?: 5, 100)
		[livreInstanceList: Livre.list(params), livreInstanceTotal: Livre.count()]
	}
	
	def remove() {
		
	}
}
