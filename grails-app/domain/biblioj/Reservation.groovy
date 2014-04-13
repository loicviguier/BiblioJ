package biblioj

class Reservation {
	
	int code
	Date dateReservation

	static hasMany = [livres:Livre]

    static constraints = {
		code unique:true, blank:false 
		dateReservation blank:false 
    }
	
	String toString(){
		dateReservation + ' Code Reservation : ' + code
	}
	
}
