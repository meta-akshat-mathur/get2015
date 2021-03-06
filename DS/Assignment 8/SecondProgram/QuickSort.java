package SecondProgram;

import java.util.ArrayList;

public class QuickSort {
	public ArrayList<Integer> quickSort(ArrayList<Integer> array,
			int lowerBound, int upperBound) {
		try {
			int index = partition(array, lowerBound, upperBound);

			// Recursively call quick sort function with left part of the
			// partitioned array
			if (lowerBound < index - 1)
				quickSort(array, lowerBound, index - 1);

			// Recursively call quick sort function with right part of the
			// partitioned array
			if (upperBound > index)
				quickSort(array, index, upperBound);
			return array;
		} catch (ArrayIndexOutOfBoundsException exe) {
			System.out.println(exe);
			return array;
		}
	}

	/**
	 * @param array
	 * @param leftmost
	 *            of array
	 * @param rightmost
	 *            of array
	 * @return index of the number placed at correct position
	 */
	private int partition(ArrayList<Integer> array, int left, int right) {
		try {
			int pivot = array.get(left);
			while (left <= right) {
				// Compares with each value of array till the number is at
				// correct position with the value in left
				while (array.get(left) < pivot)
					left++;

				// Compares with each value of array till the number is at
				// correct position with the value in right
				while (array.get(right) > pivot)
					right--;

				// If number is not at correct position then it is swapped with
				// the number stored in array at that index
				if (left <= right) {
					int temporary = array.get(left);
					array.set(left, array.get(right));
					array.set(right, temporary);
					left++;
					right--;
				}
			}
			return left;

		} catch (ArrayIndexOutOfBoundsException exe) {
			System.out.println(exe);
			return array.size();
		}

	}
}
