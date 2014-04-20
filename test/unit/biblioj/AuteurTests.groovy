package biblioj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Auteur)
class AuteurTests {

	def auteur

	void setUp() {
		mockForConstraintsTests(Auteur)
		auteur = new Auteur(nom: "Ryan", prenom: "Gosling")
	}

	void testNom() {
		assert auteur.nom == "Ryan"
	}

	void testPrenom() {
		assert auteur.prenom == "Gosling"
	}

	void testBlanks() {
		auteur = new Auteur(nom: '', prenom: '')
		assertFalse auteur.validate()
		assertEquals 'Nom is blank.', 'blank', auteur.errors['nom']
		assertEquals 'Prenom is blank.', 'blank', auteur.errors['prenom']
		auteur = new Auteur(nom: 'Ryan', prenom: 'Gosling')
		assertTrue auteur.validate()
	}

	void testToString() {
		assert auteur.toString() == "Ryan Gosling"
	}
}
