import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * this is the main class of guest house system.
 * 
 * @author Akshat
 *
 */
public class GuestHouse {

	private static Scanner scanner;
	private static Scanner scanner2;

	/**
	 * take input choice from user
	 * 
	 * @return
	 */
	static int userChoice() {
		int number;
		scanner2 = new Scanner(System.in);
		try {
			number = scanner2.nextInt();
			return number;
		} catch (InputMismatchException e) {
			System.out.println("enter only integer");
			number = userChoice();
		}
		return number;
	}

	public static void main(String args[]) {
		scanner = new Scanner(System.in);
		RoomsAllotment rooms = new RoomsAllotment();
		do {
			System.out.println("enter your choice"
					+ "\n 1. to allocate anew room"
					+ "\n 2. to search guest name in a room"
					+ "\n 3. to search room number of a guest name"
					+ "\n 4. to display the details of booking"
					+ "\n 5. to exit from the system");
			int choice = userChoice();
			switch (choice) {
			case 1:
				rooms.allocateRoom();
				break;
			case 2:
				System.out.println("enter the room number");
				int roomNumber = userChoice();
				rooms.searchByRoom(roomNumber);
				break;
			case 3:
				System.out.println("enter the name of guest");
				String nameOfGuest = scanner.nextLine();
				rooms.searchByName(nameOfGuest);
				break;
			case 4:
				rooms.showBookingDetail();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("enter correct option");
			}
		} while (true);
	}
}
