import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main function
 * @author Akshat
 *
 */
public class PrintingJob {

	private static Scanner sc;

	/**
	 * takes input from user and check for incorrect input
	 * 
	 * @return
	 */
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

		PrintingProcess printingProcess = new PrintingProcess(null, 0);
		// isprintInitialize checks that the job queue is initialize or not
		boolean isPrintInitialize = false;
		do {
			int choice;
			/* Showing menu */
			System.out.println("\n1. Initialize the job queue of printer");
			System.out.println("2. Add one more print job request");
			System.out
					.println("3. Show the current printing job to be serviced");
			System.out.println("4. Service the current print job");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = userInput();
			switch (choice) {

			case 1:
				if (isPrintInitialize) {
					System.out
							.println("\nJob queue is already initialize. select option 2 to add more job to job queue");
				} else {
					printingProcess.jobInsertion();
					isPrintInitialize = true;
				}
				break;
			case 2:
				if (isPrintInitialize) {
					System.out.println(isPrintInitialize);
					printingProcess.addJob();
				} else {
					System.out
							.println("\nFirst initialize the job queue then add job to queue. select 1 option");
				}
				break;
			case 3:
				printingProcess.currentJob();
				break;
			case 4:
				printingProcess.serviceJob();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Enter correct choice");
				break;
			}
		} while (true);
	}

}
