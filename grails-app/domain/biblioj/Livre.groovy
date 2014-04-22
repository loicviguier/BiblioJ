package biblioj

import java.sql.Timestamp;

class Livre {
	
	String titre
	Integer nombreExemplaires
	Integer nombreExemplairesDisponibles

	static hasMany = [reservations:Reservation, auteurs:Auteur]
	static belongsTo = Reservation
	TypeDocument type;
	
	static fetchMode = [auteurs : 'eager']
	
	Timestamp version
	
    static constraints = {
		titre blank:false
		nombreExemplaires nullable: false
		nombreExemplairesDisponibles nullable: false
		type nullable: false
    }
	
	String toString() {
		titre + ', nombre d\'exemplaire : ' + nombreExemplairesDisponibles
	}
	
}
