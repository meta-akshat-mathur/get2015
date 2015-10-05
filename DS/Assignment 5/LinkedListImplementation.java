import java.util.LinkedList;

public class LinkedListImplementation {

	static LinkedList<Integer> linkList = new LinkedList<Integer>();

	/**
	 * @param index of the linkedList element
	 * @param element value
	 */
	public static void insertion(int index, int element) {
		if (index == linkList.size()) {
			linkList.add(element);
		} else if (((int) linkList.get(index) < element)
				&& ((index + 1) <= linkList.size())) {
			insertion(index + 1, element);
		} else {
			linkList.add(index, element);
		}
	}

	public void printLinkedList() {

		System.out.print(linkList);
	}

}
