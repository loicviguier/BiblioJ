package biblioj

import java.sql.Timestamp

class Reservation {
	
	Integer code
	Date dateReservation

	static hasMany = [livres:Livre]
	
	static fetchMode = [livres: 'eager']
	
	Timestamp version

    static constraints = {
		code unique:true, nullable: false 
		dateReservation nullable: false 
    }
	
	String toString(){
		dateReservation + ' Code Reservation : ' + code
	}
	
}
