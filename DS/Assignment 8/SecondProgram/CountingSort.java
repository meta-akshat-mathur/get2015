package SecondProgram;

import java.util.ArrayList;

public class CountingSort {
	/**
	 * Counting sort for 2digit variable
	 * @param array as in input
	 * @return soted array
	 */
	public ArrayList<Integer> countingSort(ArrayList<Integer> list) {
		int index = 0, count;
		int countingNumberIndex = 0;

		ArrayList<Integer> countingNumber = new ArrayList<Integer>(100);
		//initializing each value of array list with zero
		for (count = 0; count < 100; count++) {
			countingNumber.add(0);
		}
		//storing the values in according to the digit and storing it on particular index
		for (Integer element : list) {
			countingNumber.set(element, (countingNumber.get(element) + 1));
		}
		//setting up back on list
		for (Integer element : countingNumber) {
			while (element != 0) {
				list.set(index, countingNumberIndex);
				index++;
				element--;
			}
			countingNumberIndex++;
		}
		return list;
	}
}
