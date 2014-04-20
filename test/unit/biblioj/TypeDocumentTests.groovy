package biblioj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TypeDocument)
class TypeDocumentTests {
   
	def type

	void setUp() {
		mockForConstraintsTests(TypeDocument)
		type = new TypeDocument(intitul: "new")
	}
	
	void testIntitul() {
		assert type.intitul == "new"
	}
	
	void testBlank() {
		type = new TypeDocument(intitul: '')
		assertFalse type.validate()
		assertEquals 'Intitul is blank.', 'blank', type.errors['intitul']
		type = new TypeDocument(intitul: "new")
		assertTrue type.validate()
	}
	
	void testToString() {
		assert type.toString() == "new"
	}
	
}
