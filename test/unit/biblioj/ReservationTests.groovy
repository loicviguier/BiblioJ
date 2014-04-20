package biblioj



import grails.test.mixin.*
import java.text.SimpleDateFormat
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Reservation)
class ReservationTests {
	
	def reservation

    void setUp() {
		mockForConstraintsTests(Reservation)
		reservation = new Reservation(code: 1, dateReservation: new Date())
	}
	
	void testCode() {
		assert reservation.code == 1
	}
	
	void testDateReservation() {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy")
		assert formater.format(reservation.dateReservation) == formater.format(new Date())
	}
	
	void testUnique() {
		def test = new Reservation(code: new Integer(1), dateReservation: new Date())
		mockForConstraintsTests(Reservation, [test])
		
		assertFalse reservation.validate()
		assertEquals 'Code is not unique.', 'unique', reservation.errors['code']
		
		reservation = new Reservation(code: 2, dateReservation: new Date())
		assertTrue reservation.validate()
	}
	
	void testNullable() {
		reservation = new Reservation()
		assertFalse reservation.validate()
		assertEquals "nullable", reservation.errors['code']
		assertEquals "nullable", reservation.errors['dateReservation']
	}
}
