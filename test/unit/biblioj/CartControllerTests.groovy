
package biblioj



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CartController)
class CartControllerTests {

    void testIndex() {
        controller.index()
        assert "/cart/list" == response.redirectedUrl
    }
	
	void testList() {
		
		def model = controller.list()
		session['cart'] = null
		
		assert session['cart'] == null
		assert model.livreInstanceList.size() == 0
		assert model.livreInstanceTotal == 0
		
		session['cart'] = []
		
		assert session['cart'].size() == 0
		assert model.livreInstanceList.size() == 0
		assert model.livreInstanceTotal == 0
	}
	
	void testAdd() {
		Livre livreInstance = new Livre(titre: "Rien ne s'oppose à la nuit", nombreExemplaires: 10, nombreExemplairesDisponibles: 5)
		controller.add(livreInstance.id)
		
		session['cart'] = null
		
		assert session['cart'] == []
		session['cart'] = []
		session['cart'] << livreInstance
		
		assert session['cart'].size() == 1
		
		assert "/livre/list" == response.redirectedUrl
	}
	
	void testRemove() {
		Livre livreInstance = new Livre(titre: "Rien ne s'oppose à la nuit", nombreExemplaires: 10, nombreExemplairesDisponibles: 5)
		def model = controller.remove(livreInstance.id)
		session['cart'] = null
		
		assert session['cart'] == []
		
		session['cart'] << livreInstance
		model.remove(livreInstance.id)
		assert session['cart'].size() == 0
		
		assert "/cart/list" == response.redirectedUrl
	}
}
