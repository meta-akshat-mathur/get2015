import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBinaryTree {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		BinaryTree mirrorImage = new BinaryTree();
		int ch;
		try {
			do {
				System.out
						.println("1. Create Tree\n2. Inorder Traverse\n3. Preorder Traverse\n4. Postorder Traverse\n5. Enter the tree to check for mirror tree\n6. Check for mirror tree\n7. Exit");
				System.out.println("Enter your choice: ");
				scanner = new Scanner(System.in);
				int choice = 0;

				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the node value: ");
					int value = scanner.nextInt();
					binaryTree.insertNode(value);
					break;
				case 2:
					binaryTree.inorderTraverse(binaryTree.root);
					break;
				case 3:
					binaryTree.preorderTraverse(binaryTree.root, true);
					break;
				case 4:
					binaryTree.postorderTraverse(binaryTree.root, true);
					break;
				case 5:
					System.out.println("Enter the node value: ");
					int input = scanner.nextInt();
					mirrorImage.insertNode(input);
					break;
				case 6:
					if (binaryTree.checkForMirrorImageOfBinaryTree(
							binaryTree.root, mirrorImage.root))
						System.out
								.println("Both trees are mirror image to each other");
					else
						System.out.println("both are not mirror image");
					break;
				case 7:
					System.exit(0);

				default:
					System.out.println("Enter the correct option");
				}
				System.out.println("\nDo you want to continue(1/0) ");
				ch = scanner.nextInt();
			} while (ch == 1);
		} catch (InputMismatchException ex) {
			System.out.println("Enter valid input ");
			main(null);
		}
	}
}
