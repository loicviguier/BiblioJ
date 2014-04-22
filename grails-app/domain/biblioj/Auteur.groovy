package biblioj

import java.sql.Timestamp;

class Auteur {
	
	String nom
	String prenom

	static hasMany = [livres:Livre]
	static belongsTo = Livre;
	
	static fetchMode = [livres: 'eager']
	
	Timestamp version

    static constraints = {
		prenom blank: false
		nom blank: false
    }
	
	String toString(){
		nom + ' ' + prenom
	}
}
