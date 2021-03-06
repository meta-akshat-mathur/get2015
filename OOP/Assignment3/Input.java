import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	// name of the user
	static String userName;

	/**
	 * takes the input from the console and check it.
	 * 
	 * @return input from user.
	 */
	int userInput() {
		int number;
		try {
			Scanner sc = new Scanner(System.in);

			number = sc.nextInt();
			if (number <= 0) {
				System.out.println("enter the correct input");
				number = userInput();
			}
			return number;
		} catch (InputMismatchException e) {
			System.out.println("enter the correct input");
			number = userInput();
			return number;
		}

	}

	/**
	 * takes string type input from user
	 * 
	 * @return the input from console
	 */
	public String input() {
		Scanner scanner = new Scanner(System.in);

		String name = scanner.nextLine();
	
		return name;

	}

	/**
	 * takes train type from user and checks if it is correct or not.
	 * 
	 * @return type of train.
	 */
	public String checkType() {
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();
		if (temp.equalsIgnoreCase("Passenger")
				|| temp.equalsIgnoreCase("Goods")) {
			return temp;
		} else {
			System.out.println("enter correct train type");
			temp = checkType();
		}
		return temp;
	}

	/**
	 * takes the detail from user like train no. and no of seat
	 * 
	 */
	public void passengerDetailsFromUser() {
		Passenger passenger = new Passenger();
		Payment payment = new Payment();
		passenger.showTrain(Passenger.refineTrainsList);
		System.out
				.println("enter the train number in which you wan't to reserve the seat");
		int trainNumberUser = userInput();
		System.out.println("enter the number of seat you wan't to resere");
		int numberOfSeat = userInput();
		boolean isAvailable = false;
		isAvailable = passenger.checkDetails(trainNumberUser, numberOfSeat);
		if (isAvailable) {
			int fare = passenger.getFare(trainNumberUser);
			boolean status = payment.doPayment(trainNumberUser, numberOfSeat,
					fare);
			if (status) {
				passenger.deductSeat(trainNumberUser, numberOfSeat);
			}
		} else {
			passengerDetailsFromUser();
		}
	}

	/**
	 * takes the detail of goods detail from user.
	 * 
	 */
	public void goodsDetailFromUser() {
		Goods goods = new Goods();
		Payment payment = new Payment();
		goods.showTrain(Goods.refineTrainsList);
		System.out
				.println("enter the train number in which you wan't to reserve the load");
		int trainNumberUser = userInput();
		System.out.println("enter the weight of your load");
		int loadWeight = userInput();
		boolean isAvailable = false;
		isAvailable = goods.checkDetails(trainNumberUser, loadWeight);
		if (isAvailable) {
			int fare = goods.getFare(trainNumberUser);
			boolean status = payment.doPayment(trainNumberUser, loadWeight,
					fare);
			if (status) {
				goods.deductWeight(trainNumberUser, loadWeight);
			}
		} else {
			goodsDetailFromUser();
		}
	}

	/**
	 * it initiates the reservation process.
	 * 
	 */
	public void startReservation() {
		Input obj = new Input();
		Passenger passenger = new Passenger();
		Goods goods = new Goods();
		System.out.println("enter your name");
		userName = obj.input();
		System.out.println("enter train type");
		String trainType = obj.checkType();
		if (trainType.equalsIgnoreCase("passenger")) {
			passenger.showTrain(Passenger.trains);
			System.out.println("enter source station");
			String source = obj.input();
			System.out.println("enter destination station");
			String destination = obj.input();
			Passenger.refineTrainsList = passenger.refineTrains(source,
					destination);
			if (Passenger.refineTrainsList.size() == 0) {
				System.out.println("no trains are found");
			} else {
				passengerDetailsFromUser();
			}
		} else {
			goods.showTrain(Goods.trains);
			System.out.println("enter source station");
			String source = obj.input();
			System.out.println("enter destination station");
			String destination = obj.input();
			Goods.refineTrainsList = goods.refineTrains(source, destination);
			if (Goods.refineTrainsList.size() == 0) {
				System.out.println("no trains are found");
			} else {
				goodsDetailFromUser();
			}
		}
	}
}
