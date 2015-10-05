import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Akshat
 *
 */
public class EmployeeManagement {

	private static Scanner scanner;
	static Set<Employee> set = new HashSet<Employee>();

	private static int userInput() {
		int number = 0;
		scanner = new Scanner(System.in);
		try {
			number = scanner.nextInt();
			return number;
		} catch (InputMismatchException e) {
			System.out.println("\nEnter only integer");
			number = userInput();
		}
		return number;
	}

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		do {
			Employee employee = new Employee();
			System.out
					.println("\n1. Enter the Employee Details\n2. Sort Details in Natural order\n3. Sort details on the basis of Employee Name\n4. Show Details\n5. Exit");
			System.out.println("\nEnter you choice ");
			int choice = userInput();
			switch (choice) {
			case 1:
				System.out.println("Enter the employee ID: ");
				employee.setEmployeeId(scanner.next().toLowerCase());
				System.out.println("Enter the employee Name: ");
				String name=scanner.next();
					employee.setEmployeeName(name);
				
				System.out.println("Enter the employee Address: ");
				employee.setEmployeeAddress(scanner.next());
				if (set.contains(employee)) {
					System.out.println("Same employee Id cant be allot");
				} else {
					set.add(employee);
				}
				break;
			case 2:
				List<Employee> listDetails = new ArrayList<Employee>(set);
				Collections.sort(listDetails);
				System.out.println(listDetails);
				break;
			case 3:
				List<Employee> listName = new ArrayList<Employee>(set);
				Collections.sort(listName, new EmployeeNameComaparator());
				System.out.println(listName);
				break;
			case 4:
				System.out.println(set);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("\nEnter correct choice");
				break;
			}

		} while (true);
	}

}
