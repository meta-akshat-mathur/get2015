public class BinaryTreeSort {
	Node root;
	String binaryTree = "";

	/**
	 * inserting value in tree
	 * 
	 * @param value
	 */
	void insertNode(int value) {
		Node newNode = new Node(value, null, null);
		if (root == null) {
			root = newNode;
		} else {
			Node currentNode = root;
			Node parent;
			while (true) {
				parent = currentNode;
				if (value < currentNode.getKey()) {
					currentNode = currentNode.getLeftNode();
					if (currentNode == null) {
						parent.setLeftNode(newNode);
						return;
					}
				} else {
					currentNode = currentNode.getRightNode();
					if (currentNode == null) {
						parent.setRightNode(newNode);
						return;
					}
				}
			}
		}
	}

	/**
	 * traversing in inorder
	 * 
	 * @param inorder
	 */
	public void inorderTraverse(Node inorder) {
		if (inorder != null) {
			inorderTraverse(inorder.getLeftNode());
			System.out.print(inorder.getKey() + "\t");
			inorderTraverse(inorder.getRightNode());
		}
	}

}