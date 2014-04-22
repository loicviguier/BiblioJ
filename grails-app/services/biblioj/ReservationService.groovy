package biblioj

class ReservationService {

  	def createReservation() {
		  int codeRes = Reservation.list().size()
		  Reservation reservation = new Reservation(livres : [], code : codeRes, dateReservation : new Date().plus(1))
		  reservation.save()
		  return reservation
	  }
	  
	  def boolean isContainsLivre(Long id,Long idReservation){
		 def reservation = Reservation.get(idReservation)
		 for(livre in reservation.livres){
			if(livre.id == id){
					 return true
			}
		}
		  
		 return false
	}
}
