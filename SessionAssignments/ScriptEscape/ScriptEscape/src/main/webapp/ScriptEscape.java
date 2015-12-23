package main.webapp;

import org.apache.commons.lang3.StringEscapeUtils;

public class ScriptEscape {

	public static void main(String[] args) {
		String input = "<script>alert(Hello JAVA)</script>";
		System.out.println(input);
		String result = StringEscapeUtils.escapeHtml4(input);
		System.out.println(result);
	}

}
