package biblioj

import java.sql.Timestamp;

class TypeDocument {
	
	String intitul
	
	Timestamp version
	
	    static constraints = {
			intitul blank: false
	    }
	
	String toString(){
		intitul
	}
}
