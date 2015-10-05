package Assignment3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("Enter a String");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		input = input.toLowerCase();
		if (Validation.isExpression(input)) {
			TruthTableGenerator truthTableObj = new TruthTableGenerator();
			truthTableObj.truthTableGenerator(input);
		} else {
			System.out.println("Enter Valid Expression");
		}
		sc.close();
	}
}
