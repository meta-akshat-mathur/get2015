import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		BinarySearch.result = result;
	}

	static int result = -1;
	ArrayList<Integer> array = new ArrayList<Integer>();

	void insert(int value) {
		array.add(value);
		Collections.sort(array);
	}

	/**
	 * @param lowerBound
	 * @param upperBound
	 * @param searchValue
	 * @return index of left most occurence else -1 if not found
	 */
	int binarySearch(int lowerBound, int upperBound, int searchValue) {
		int mid = (lowerBound + upperBound) / 2;
		if (lowerBound <= upperBound) {
			if (array.get(mid) == searchValue) {
				result = mid;
				return binarySearch(lowerBound, mid - 1, searchValue);
			} else {
				if (array.get(mid) > searchValue)
					return binarySearch(lowerBound, mid - 1, searchValue);
				else
					return binarySearch(mid + 1, upperBound, searchValue);
			}
		} else
			return result;

	}

}
