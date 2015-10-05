import java.util.LinkedList;

public class QueueImplementation {
	LinkedList<Integer> linkList = new LinkedList<Integer>();

	/**
	 * @param value to inserting at last
	 */
	void enqueue(int value) {
		if (linkList.size() == 0) {
			linkList.addFirst(value);
		} else {
			linkList.addLast(value);
		}

	}

	/**
	 * Deleting first element from queue
	 */
	void dequeue() {
		if (linkList.size() == 0) {
			System.out.println("No element in the queue");
		} else {
			linkList.removeFirst();
		}
	}

	/**
	 * @return the first element
	 */
	int peek() {
		return linkList.getFirst();

	}

	public void printQueue() {
		System.out.println(linkList);
		
	}

}
