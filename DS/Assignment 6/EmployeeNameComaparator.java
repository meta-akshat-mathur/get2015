import java.util.Comparator;

/**
 * @author Akshat
 *
 */
public class EmployeeNameComaparator implements Comparator<Employee> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Employee arg0, Employee arg1) {
		Employee e1 = (Employee) arg0;
		Employee e2 = (Employee) arg1;
		return e1.getEmployeeName().compareTo(e2.getEmployeeName());
	}

}
