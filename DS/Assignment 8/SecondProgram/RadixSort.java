package SecondProgram;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

	/**
	 * @param array
	 * @param noOfDigit
	 *            on maximum element
	 * @return sorted array
	 */
	public ArrayList<Integer> radixSort(ArrayList<Integer> array, int noOfDigit) {
		@SuppressWarnings("unchecked")
		List<Integer>[] listArray = new ArrayList[10];
		int size = array.size();
		int remainder = 10;
		int divisor = 1;
		// initializing arraylist with 0
		for (int intialize = 0; intialize < 10; intialize++)
			listArray[intialize] = new ArrayList<Integer>();
		// iterating loop till the maximum number of digit value in a array
		while (noOfDigit != 0) {
			for (int count = 0; count < size; count++) {
				int indexOfListArray = (array.get(0) % remainder) / divisor;
				listArray[indexOfListArray].add(array.remove(0));
			}

			for (int count = 0; count < 10; count++) {
				while (!listArray[count].isEmpty())
					array.add(listArray[count].remove(0));
			}
			remainder *= 10;
			divisor *= 10;
			noOfDigit--;
		}
		return array;
	}

}
