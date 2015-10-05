import java.util.InputMismatchException;
import java.util.Scanner;

public class QueueMenu {
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

	public static void main(String[] args) {
		QueueImplementation queue = new QueueImplementation();
		int value;
		do {
			System.out
					.println(" \n 1. Insertion in Queue.\n 2. Deletion in Queue\n 3. Peek value\n 4. Display Queue\n 5. Exit");
			System.out.println("Enter your choice ");
			int ch = userInput();
			switch (ch) {
			case 1:
				System.out.println("Enter the value to be inserted:");
				value = userInput();
				queue.enqueue(value);
				break;
			case 2:
				queue.dequeue();
				break;
			case 3:
				int peek = queue.peek();
				System.out.println("The peek value is " + peek);
				break;
			case 4: 
				queue.printQueue();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Enter correct choice: ");
			}
		} while (true);
	}
}
