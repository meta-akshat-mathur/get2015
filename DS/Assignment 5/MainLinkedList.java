import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLinkedList {
	private static Scanner sc;

	private static int userInput() {
		int number = 0;
		sc = new Scanner(System.in);
		try {
			number = sc.nextInt();
			return number;
		} catch (InputMismatchException e) {
			System.out.println("\nEnter only integer");
			number = userInput();
		}
		return number;
	}

	public static void main(String args[]) {
		LinkedListImplementation linkList = new LinkedListImplementation();
		int value;
		do {
			System.out
					.println(" \n 1. Enter the element in the linked list.\n 2. Show Linked List\n 3. Exit");
			System.out.println("Enter your choice ");
			int ch = userInput();
			switch (ch) {
			case 1:
				System.out.println("Enter the value:");
				value = userInput();
				LinkedListImplementation.insertion(0, value);
				break;
			case 2:
				linkList.printLinkedList();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Enter correct choice: ");
			}
		} while (true);
	}
}
