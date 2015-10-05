package Assignment3;

import java.util.Scanner;

/**
 * @author Akshat
 *
 */
public class MyArrayList {
	private int myArray[];
	private int size = 0;
	private static Scanner sc;

	/**
	 * default constructor initializing array size
	 */
	public MyArrayList() {
		myArray = new int[10];
	}

	/**
	 * will merge two lists
	 * 
	 * @param first
	 *            arrayList
	 * @param second
	 *            arrayList
	 * @return merged arrayList
	 */
	public MyArrayList mergeLists(MyArrayList arrayList, MyArrayList arrayList1) {
		for (int i = 0; i < arrayList1.size; i++) {
			arrayList.addElement(arrayList1.getItem(i));

		}
		return arrayList;
	}

	/**
	 * Adding an item into array list and check if list is full, then resizing
	 * the arraylist
	 * 
	 * @param item
	 *            that needed to the added in the list
	 */
	public void addElement(int item) {
		if (size < myArray.length) {
			myArray[size] = item;
			size++;
		} else {
			int newArray[] = new int[myArray.length + 5];
			for (int i = 0; i < myArray.length; i++) {
				newArray[i] = myArray[i];
			}
			newArray[size] = item;
			size++;
			myArray = newArray;
		}
	}

	/**
	 * Adding an item into array list at the given particular location i
	 * 
	 * @param index
	 *            position of the list
	 * @param item
	 *            that to added
	 * @return
	 */
	public int[] addElementAtPosition(int index, int item) {
		for (int i = size; i > index; i--) {
			myArray[i] = myArray[i - 1];
		}
		myArray[index] = item;
		size++;
		return myArray;
	}

	/**
	 * Retrieving the first occurrence of an item
	 * 
	 * @param item
	 *            that position needed to be retrive
	 * @return index of that item
	 */
	public int retrievingPosition(int item) {
		for (int i = 0; i < size; i++) {
			if (myArray[i] == item) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * retrieving position of item after a particular position
	 * 
	 * @param item
	 *            that
	 * @param position
	 *            after which there is an occurance of element
	 * @return position
	 */
	public int retrievingPositionBasedOnLocation(int item, int position) {
		for (int i = position; i < size; i++) {
			if (myArray[i] == item) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Removing an item based on particular location
	 * 
	 * @param index
	 * @return
	 */
	public int[] removeAtIndex(int index) {
		for (int i = index; i < size; i++) {
			myArray[i] = myArray[i + 1];
		}
		size--;
		return myArray;
	}

	/**
	 * Remove given particular item from the arraylist
	 * 
	 * @param item
	 *            that to be removed
	 * @return the arrayList
	 */
	public int[] removeItem(int item) {
		for (int i = 0; i < size; i++) {
			if (myArray[i] == item) {
				for (int j = i; j < size - 1; j++) {
					myArray[j] = myArray[j + 1];
				}
			}
		}
		size--;
		return myArray;
	}

	/**
	 * print all elements of array
	 */
	public void printAllElements() {
		for (int i = 0; i < size; i++) {
			System.out.println(myArray[i]);
		}
	}

	/**
	 * Return Reverse of arraylist
	 * 
	 * @return reversed arrayList
	 */
	public void reverseArrayList() {
		int start = 0, end = size - 1;
		int temp;
		while (start <= end) {
			temp = myArray[start];
			myArray[start] = myArray[end];
			myArray[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * will return value at given position
	 * 
	 * @param index
	 *            position
	 * @return item
	 */
	public int getItem(int index) {
		return myArray[index];
	}

	/**
	 * Clear the list i.e. remove all the elements of the list
	 */
	public void clearList() {
		size = 0;
	}

	public void sort() {
		for (int index = 0; index < size; index++) {
			int min = (int) myArray[index];
			for (int index2 = index + 1; index2 < size; index2++) {
				if (min > (int) myArray[index2]) {
					int temp = min;
					min = (int) myArray[index2];
					myArray[index2] = temp;
				}
			}
			myArray[index] = min;
		}
	}

	public static void main(String args[]) {

		MyArrayList arrayList = new MyArrayList();
		int ch, item, loc;
		sc = new Scanner(System.in);
		while (true) {
			System.out
					.print("\n 1. Adding an item "
							+ "\n 2. Adding an item into array list at the given particular location i"
							+ "\n 3. Retrieving the first occurrence of an item based on its given location"
							+ "\n 4. Retrieving the first index of particular item in the arraylist"
							+ "\n 5. Removing an item based on particular location"
							+ "\n 6. Remove given particular item from the arraylist  "
							+ "\n 7. Clear the list i.e. remove all the elements of the list"
							+ "\n 8. Reverse the arraylist"
							+ "\n 9. Display List" + "\n 10. Merge"
							+ "\n 11. Sort" + "\n12. Exit");
			System.out.print("\n Enter Your Choice : ");
			ch = sc.nextInt();
			switch (ch) // Apply switch case and call corresponding method
						// according to the choice
			{
			case 1:
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				arrayList.addElement(item);
				break;
			case 2:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				arrayList.addElementAtPosition(loc, item);
				break;
			case 3:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				int value = arrayList.retrievingPosition(loc);
				System.out.println("The element at " + loc + "is " + value);
				break;
			case 4:
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				int position = arrayList.retrievingPosition(item);
				System.out.println("The " + item + "is at position  "
						+ position);
				break;
			case 5:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				arrayList.removeAtIndex(loc);
				break;
			case 6:
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				arrayList.removeItem(item);
				break;
			case 7:
				arrayList.clearList();
				break;
			case 8:
				arrayList.reverseArrayList();
				break;
			case 9:
				arrayList.printAllElements();
				break;
			case 10:
				MyArrayList arrayList1 = new MyArrayList();
				arrayList1.addElement(6);
				arrayList1.addElement(7);
				arrayList1.addElement(9);
				arrayList.mergeLists(arrayList, arrayList1);
				break;
			case 11:
				arrayList.sort();
				break;

			case 12:
				System.exit(0);
			}
		}
	}

}
