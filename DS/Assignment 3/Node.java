/**
 * @author Akshat
 *
 */
public class Node {
	int key;
	Node leftNode;
	Node rightNode;

	Node() {

	}

	Node(int key, Node leftNode, Node rightNode) {
		this.key = key;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

}
