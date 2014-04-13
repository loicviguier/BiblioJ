package biblioj

class Livre {
	
	String titre
	int nombreExemplaires
	int nombreExemplairesDisponibles

	static hasMany = [reservations:Reservation, auteurs:Auteur]
	static belongsTo = Reservation
	TypeDocument type;
	
    static constraints = {
		titre blank:false
		nombreExemplaires blank:false 
    }
	
	String toString() {
		titre + ', nombre d\'exemplaire : ' + nombreExemplairesDisponibles
	}
	
}
