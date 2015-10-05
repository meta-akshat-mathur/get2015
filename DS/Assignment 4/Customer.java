import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * this class is use to hold the data of Customer
 * 
 * @author Akshat
 * 
 */
public class Customer {

	// name of the person
	String name;
	// age of the person
	int age;
	private Scanner scanner;
	private Scanner scanner2;

	/**
	 * get the name of the person
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	String inputName() {
		scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		return name;
	}

	/**
	 * set the name of the person
	 * 
	 * @param name
	 */
	public void setName() {
		this.name = inputName();
	}

	/**
	 * get the age of person
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

	int inputAge() {
		scanner2 = new Scanner(System.in);
		int number;
		try {
			number = scanner2.nextInt();
			if (number <= 0) {
				System.out
						.println("age can't be equal to or less than 0. enter correct age");
				number = inputAge();
			}
			return number;
		} catch (InputMismatchException e) {
			System.out.println("kindly enter age in integer only");
			number = inputAge();
		}
		return 0;
	}

	/**
	 * set the age of person
	 * 
	 * @param age
	 */
	public void setAge() {
		this.age = inputAge();
	}

}
