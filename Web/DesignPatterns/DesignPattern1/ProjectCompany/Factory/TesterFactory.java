package ProjectCompany.Factory;

import ProjectCompany.Model.Engineer;
import ProjectCompany.Model.EngineerType;
import ProjectCompany.Model.Tester;


/**
 * Class to create objects of Tester class
 * @author Akshat
 *
 */
public class TesterFactory extends Tester implements EngineerFactory{

	public TesterFactory() {
	}
	
	/** Parameterized Constructor that will call its
	 * super class constructor 
	 * @param name
	 * @param type
	 */
	private TesterFactory(String name , EngineerType type) {
		super(name , type);
	}

	@Override
	public Engineer createEngineer(String name, EngineerType type) {
		return new TesterFactory(name, type);
	}
	
}
