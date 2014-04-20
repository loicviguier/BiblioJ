package biblioj

class Auteur {
	
	String nom
	String prenom

	static hasMany = [livres:Livre]
	static belongsTo = Livre;

    static constraints = {
		prenom blank: false
		nom blank: false
    }
	
	String toString(){
		nom + ' ' + prenom
	}
}
