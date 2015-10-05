public class TestValidations {
	boolean checkForString(String infix) {
		boolean flag = true;
		String operater = "[\\+\\-\\*\\/\\%]";
		String operters;
		String operands;
		String number = "[0-9]";
		int lenghtCounter = 0;

		if (!checkParenthesis(infix)) {
			return false;
		}
		for (int count = 0; count < infix.length(); count++) {

			if (lenghtCounter % 2 == 0) {
				operands = "" + infix.charAt(count);
				if (operands.matches(number)) {
					System.out
							.println("you cannot insert number. it will apply only for alphabhate");
					return false;
				}
				if (operands.equals("(") || operands.equals(")")) {
					continue;

				}

				else if (operands.matches(operater)) {

					flag = false;
					return flag;
				} else {
					lenghtCounter++;
				}
			} else {
				operters = "" + infix.charAt(count);
				if (operters.matches(number)) {
					System.out
							.println("you cannot insert number. it will apply only for alphabhate");
					return false;
				}
				if (operters.equals("(") || operters.equals(")")) {
					continue;
				} else if (!operters.matches(operater)){

					flag = false;
					return flag;
				} else {
					lenghtCounter++;
				}
				if (count == infix.length() - 1
						&& (operters.equals("(") || operters.equals(")"))) {
					flag = false;
				}
			}
		}
		return flag;
	}

	/**
	 * checkForString is a function which is used to check the parenthesis in
	 * the string
	 */
	boolean checkParenthesis(String infix) {
		int countforLeft = 0, countforRight = 0;
		for (int count = 0; count < infix.length(); count++) {
			if (infix.charAt(count) == '(') {
				countforLeft++;
			} else if (infix.charAt(count) == ')') {
				countforRight++;
			}
		}
		if (countforLeft == countforRight) {
			return true;
		} else {
			return false;
		}

	}
}
