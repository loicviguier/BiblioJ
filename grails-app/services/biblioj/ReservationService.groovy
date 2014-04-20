package biblioj

class ReservationService {

  	def createReservation() {
		  Reservation reservation = new Reservation(code : 123, dateReservation : new Date().plus(2))
		  reservation.save()
		  return reservation
	  }
}
