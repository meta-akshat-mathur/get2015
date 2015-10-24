package ProjectCompany.Model;


/**
 *  Class to create Developers 
 * @author Akshat
 *
 */
public class Developer extends Engineer {

	
	/**
	 * Protected parameterized constructor to create Developer
	 * @param name
	 * @param role
	 */
	protected Developer(String name, EngineerType role) {
		super(name , role);
	}
	
	protected Developer() {
		
	}

}
