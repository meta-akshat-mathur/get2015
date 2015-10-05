package SecondProgram;

import java.util.ArrayList;

public class BubbleSort {
	/**
	 * @param array
	 * @return sorted array
	 */
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
		int count1, count2, temp;
		for (count1 = 0; count1 < (array.size() - 1); count1++) {
			for (count2 = 0; count2 < (array.size() - count1) - 1; count2++) {
				if (array.get(count2) > array.get(count2 + 1)) {
					temp = array.get(count2);
					array.set(count2, array.get(count2 + 1));
					array.set(count2 + 1, temp);
				}
			}
		}
		return array;
	}
}
