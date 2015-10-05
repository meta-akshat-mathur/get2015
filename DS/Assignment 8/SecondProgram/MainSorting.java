package SecondProgram;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainSorting {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		do {
			System.out
					.println("\n1. Insert Values in  Array\n2. Comparison Sorting\n3. Linear Sorting\n4. Display Array\n5. Exit");
			System.out.println("Enter you choice ");
			int choice = userInput();
			switch (choice) {
			case 1:
				System.out.println("Enter the values in array: ");
				int value = userInput();
				array.add(value);
				break;
			case 2:
				if (array.size() != 0) {
					if (array.size() <= 10) {
						BubbleSort bSort = new BubbleSort();
						System.out.println("Bubble Sort:: ");
						System.out.println(bSort.bubbleSort(array));
					} else {
						System.out.println("Quick Sort: ");
						QuickSort qSort = new QuickSort();
						System.out.println(qSort.quickSort(array, 0,
								array.size() - 1));
					}
				} else {
					System.out
							.println("Firstly please insert values in an array.");
				}
				break;
			case 3:
				if (array.size() != 0) {
					if (!checkForNegativeInputInArray(array)) {
						if (countNumberOfDigit(array) <= 2) {
							CountingSort cSort = new CountingSort();
							System.out.println("Counting Sort:: ");
							System.out.println(cSort.countingSort(array));
						} else {
							RadixSort rSort = new RadixSort();
							System.out.println("Radix Sort:: ");
							System.out.println(rSort.radixSort(array,
									countNumberOfDigit(array)));
						}
					} else {
						System.out
								.println("The array contains negative number therefore linear sort can't be performed.");
					}
				} else {
					System.out
							.println("Firstly please insert values in an array.");
				}
				break;
			case 4:
				if (array.size() != 0) {
					System.out.println("The array is: " +array);
				} else {
					System.out.println("The array is empty. ");
				}

				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Enter correct option ");
			}
		} while (true);
	}
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

	private static int countNumberOfDigit(ArrayList<Integer> array) {
		int max = 0;
		int count, noOfDigit = 0;
		for (count = 1; count < array.size() - 1; count++) {
			if (array.get(count) > max) {
				max = array.get(count + 1);
			}
		}
		while (max != 0) {
			max = max / 10;
			noOfDigit++;
		}
		return noOfDigit;
	}

	private static Boolean checkForNegativeInputInArray(ArrayList<Integer> array) {
		int count;
		for (count = 0; count < array.size(); count++) {
			if (array.get(count) < 0) {
				return true;
			}
		}
		return false;

	}

}
