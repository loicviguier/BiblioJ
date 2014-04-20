package biblioj

class Reservation {
	
	Integer code
	Date dateReservation

	static hasMany = [livres:Livre]

    static constraints = {
		code unique:true, nullable: false 
		dateReservation nullable: false 
    }
	
	String toString(){
		dateReservation + ' Code Reservation : ' + code
	}
	
}
