package biblioj

class TypeDocument {
	
	String intitul

    static constraints = {
		intitul blank: false
    }
	
	String toString(){
		intitul
	}
}
