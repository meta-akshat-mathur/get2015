public class InfixToPostfixConversion extends StackNode {

	/**
	 * @param infix
	 *            expression
	 * @return postfix expression
	 */
	String infixToPostfix(String infix) {
		//
		StackNode temp1 = start;
		StackNode temp = new StackNode();
		char ch;
		String postfix = ""; // take a postfix String which contains the result
		int i = 0;
		if (infix.charAt(0) != '(') {
			infix = '(' + infix + ')'; // at starting if brackets are not then
										// add brackets in infix string
		}
		temp.push(infix.charAt(0)); // push first item in stack

		for (i = 1; i < infix.length(); i++) {
			if ((Character.isDigit(infix.charAt(i)))
					|| (Character.isLetter(infix.charAt(i))))
			// if character of string is a number or a letter than put it into
			// postfix string
			{
				postfix = postfix + infix.charAt(i);
			}

			if (start == null) // if stack is empty than push character into
								// stack
			{
				temp.push(infix.charAt(i));
			} else {
				ch = (char) temp.peep();
				if ((infix.charAt(i) == '+') || (infix.charAt(i) == '-')) {
					if (ch == '*' || ch == '/') // compare infix string
												// character to peep element of
												// stack
					{
						postfix = postfix + ch;
						temp.pop();
					}
					if (start == null) {
						temp.push(infix.charAt(i));
					} else {
						ch = (char) temp.peep();
						if (ch == '+' || ch == '-') {
							postfix = postfix + ch;
							temp.pop();
						}
						temp.push(infix.charAt(i));
					}
				} else if ((infix.charAt(i) == '*') || (infix.charAt(i) == '/')) {
					if (ch == '*' || ch == '/') {
						postfix = postfix + ch;
						temp.pop();
					}
					temp.push(infix.charAt(i));
				} else if (infix.charAt(i) == '(')
				// if open bracket character is come than put it into stack
				{
					temp.push(infix.charAt(i));
				} else if (infix.charAt(i) == ')') {
					ch = (char) temp.peep();
					while (ch != '(') {
						postfix = postfix + ch;
						temp.pop();
						ch = (char) temp.peep();
					}
					temp.pop();
				}
			}
		}

		while (start != null)
		// if elements are left in stack than put all elements into postfix
		// string
		{
			ch = (char) temp.peep();
			temp.pop();
			postfix = postfix + ch;
		}
		start = temp1;
		return postfix;
	}
}
