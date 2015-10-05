import java.util.Scanner;

public class MainClass {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		InfixToPostfixConversion conversion = new InfixToPostfixConversion();
		System.out.println("Enter the infix expression: ");
		String infix = scanner.nextLine();
		TestValidations testValidations = new TestValidations();
		boolean flag = false;
		while (!flag) {
			if (testValidations.checkForString(infix)) {
				String postfix = conversion.infixToPostfix(infix);
				System.out.println(postfix);
				flag = true;
			} else {
				System.out.println("Enter the infix expression: ");
				infix = scanner.nextLine();
			}
		}
	}
}
