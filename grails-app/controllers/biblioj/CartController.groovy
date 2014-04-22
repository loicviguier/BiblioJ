package biblioj

class CartController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { 
		redirect(action: "list", params: params)
	}
	
	def list(Integer max){
		params.max = Math.min(max ?: 5, 100)
		
		if(!session['cart']){
			[livreInstanceList: [], livreInstanceTotal: 0]
		} else {
			[livreInstanceList: session['cart'], livreInstanceTotal: session['cart'].size()]
		}
	}
	
	def add(Long id) {
		Livre livreInstance = Livre.get(id)
		
		if(!session['cart']){
			session['cart'] = []
		}
		
		session['cart'] << livreInstance
		
		redirect(action: "list",controller : "livre")
	}
	
	def remove(Long id) {
		int index = id
		def livreInstanceList = session['cart']
		Livre livreInstance = livreInstanceList[index]
		
		if(session['cart'].size() > 1){
			session['cart'].remove(index)
		} else {
			session.removeAttribute('cart')
		}
		
		redirect(action: "list")
	}
	
}
