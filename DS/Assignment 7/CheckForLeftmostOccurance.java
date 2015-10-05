import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckForLeftmostOccurance {

	private static Scanner scanner;

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

	public static void main(String args[]) {
		scanner = new Scanner(System.in);
		BinarySearch bSearch = new BinarySearch();
		do {

			System.out
					.println("\n1. Enter the values in array\n2. Enter the value to be searched\n3. Display Array\n4. Exit  ");
			System.out.println("Enter you choice ");
			int choice = userInput();
			switch (choice) {
			case 1:
				System.out.println("Enter the value to be inserted");
				int value = userInput();
				bSearch.insert(value);
				break;
			case 2:
				System.out.println("Enter the element to be searched: ");
				int searchValue = userInput();
				BinarySearch.result = -1;
				int result = bSearch.binarySearch(0, bSearch.array.size() - 1,
						searchValue);
				if (result == -1) {
					System.out.println("Element not found");
				} else {
					System.out.print("The value is at position " + result);
				}
				break;
			case 3:
				System.out.println(bSearch.array);
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Enter correct input");
				break;
			}
		} while (true);

	}
}