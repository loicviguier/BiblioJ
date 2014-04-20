package biblioj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Livre)
class LivreTests {

    Livre livre
	Auteur auteur
	TypeDocument type

	void setUp() {
		mockForConstraintsTests(Livre)
		
		auteur = new Auteur(nom: "Collins", prenom: "Suzanne")
		type = new TypeDocument(intitul: "Livre ado")
		livre = new Livre(titre: "Hunger games", nombreExemplaires: 20, nombreExemplairesDisponibles: 3)
		
		livre.type = type
		livre.auteurs = []
		livre.reservations = []
	}
	
	void testTitre() {
		assert livre.titre == "Hunger games"
	}
	
	void testNombreExemplaires() {
		assert livre.nombreExemplaires == 20
	}
	
	void testNombreExemplairesDisponibles() {
		assert livre.nombreExemplairesDisponibles == 3
	}
	
	void testType() {
		assert livre.getType() == type
	}
	
	void testBlank() {
		livre = new Livre(titre: '')
		assertFalse livre.validate()
		assertEquals 'Titre is blank.', 'blank', livre.errors['titre']
		livre = new Livre(titre: "Hunger games")
		//assertTrue livre.validate()
	}
	
	void testNullable() {
		livre = new Livre()
		assertFalse livre.validate()
		assertEquals 'NombreExemplaires is null.', 'nullable', livre.errors['nombreExemplaires']
		assertEquals 'NombreExemplairesDisponibles is null.', 'nullable', livre.errors['nombreExemplairesDisponibles']
		assertEquals 'Type is null.', 'nullable', livre.errors['type']
		livre = new Livre(titre: "Hunger games", nombreExemplaires: 20, nombreExemplairesDisponibles: 3)
		livre.type = type
		assertTrue livre.validate()
	}
	
	void testToString() {
		assert livre.toString() == 'Hunger games, nombre d\'exemplaire : 3'
	}
	
}
