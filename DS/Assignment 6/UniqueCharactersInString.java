import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Akshat
 *
 */
public class UniqueCharactersInString {

	private static HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
	private static Scanner scanner;
	private static Scanner sc;

	/**
	 * stores the unique characters in set 
	 * @param string
	 * @return the number of unique characters
	 */
	public static int insertInSet(String string) {
		Set<String> set = new HashSet<String>();
		for (int store = 0; store < string.length(); store++)
			set.add(string.charAt(store) + "");
		System.out.println("The Unique characters in string are " + set);
		return set.size();

	}

	/**
	 * checking validations in input
	 * @return 
	 */
	public static int userInput() {
		int number = 0;
		sc = new Scanner(System.in);
		try {
			number = sc.nextInt();
			if (number < 0) {
				System.out.println("number can't be negative");
				number = userInput();
			}
			return number;
		} catch (InputMismatchException e) {
			System.out.println("\nEnter only integer");
			number = userInput();
		}
		return number;
	}

	/**
	 * calculate the unique character in string
	 * @param string
	 */
	public static void calculateUniqueCharacterOccerence(String string) {
		string = string.toLowerCase();
		if (stringMap.containsKey(string))
			System.out.println("The same string is stored earlier -> "
					+ stringMap.get(string));
		else {
			stringMap.put(string, insertInSet(string));
			System.out.println("The Unique characters in that string is -> "
					+ stringMap.get(string));
		}
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int choice = 0;
		/* Showing menu */
		while (choice != 2) {
			System.out.println("1. Enter String");
			System.out.println("2. Exit");
			System.out.println("Enter your choice: ");
			choice = userInput();
			switch (choice) {
			case 1:
				System.out.println("Enter the string: ");
				String string = scanner.nextLine();
				string = string.replaceAll("\\s", "");
				calculateUniqueCharacterOccerence(string);
				break;
			case 2:
				System.exit(0);
				break;

			default:
				System.out.println("Enter correct choice");
				break;
			}
		}

	}

}
