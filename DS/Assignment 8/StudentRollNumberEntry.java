import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentRollNumberEntry {
	private static Scanner scanner;

	public static void main(String args[]) {
		BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
		do {
			System.out
					.println("\n1. Enter the student's roll number\n2. Display student's roll. number\n3. Exit");
			System.out.print("Enter your choice: ");
			int choice = userInput();
			switch (choice) {
			case 1:
				System.out.println("Enter the students roll Number: ");
				int value = userInput();
				binaryTreeSort.insertNode(value);
				break;
			case 2:
				System.out.println("\nThe students roll number in order are: ");
				binaryTreeSort.inorderTraverse(binaryTreeSort.root);
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Enter the valid input.");
			}
		} while (true);
	}

	/**
	 * validate user input
	 * @return
	 */
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
}
