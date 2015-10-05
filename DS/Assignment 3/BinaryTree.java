public class BinaryTree {
	Node root;
	String mirrorBinaryTree = "";
	String binaryTree = "";

	/**
	 * inserting value in tree
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
	 * @param inorder
	 */
	public void inorderTraverse(Node inorder) {
		if (inorder != null) {
			inorderTraverse(inorder.getLeftNode());
			System.out.print(inorder.getKey() + "\t");
			inorderTraverse(inorder.getRightNode());
		}
	}

	/**
	 * preorder traversing
	 * @param preorder
	 * @param flag to check for printing or not
	 */
	public void preorderTraverse(Node preorder, boolean flag) {
		if (preorder != null) {
			if (flag)
				System.out.print(preorder.getKey() + "\t");
			else
				mirrorBinaryTree = preorder.getKey() + mirrorBinaryTree;
			preorderTraverse(preorder.getLeftNode(), flag);
			preorderTraverse(preorder.getRightNode(), flag);

		}
	}

	/**
	 * postorder traversing
	 * @param postorder
	 * @param flag
	 */
	public void postorderTraverse(Node postorder, boolean flag) {
		if (postorder != null) {
			postorderTraverse(postorder.getLeftNode(), flag);
			postorderTraverse(postorder.getRightNode(), flag);
			if (flag)
				System.out.print(postorder.getKey() + "\t");
			else
				binaryTree = postorder.getKey() + binaryTree;

		}
	}

	/**
	 * @param original tree
	 * @param mirror tree
	 * @return
	 */
	public boolean checkForMirrorImageOfBinaryTree(Node originalNode,
			Node mirrorNode) {
		preorderTraverse(originalNode, false);
		postorderTraverse(mirrorNode, false);

		// mirrorMinaryTree=reverse(mirrorMinaryTree);
		System.out.println(binaryTree + "    " + mirrorBinaryTree);
		if (mirrorBinaryTree.equals(binaryTree))
			return true;
		else
			return false;

	}
}