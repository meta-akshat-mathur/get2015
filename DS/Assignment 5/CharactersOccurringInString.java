import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CharactersOccurringInString {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Enter string");
		String string = scanner.nextLine();
		convert(string);
	}

	/**
	 * @param string 
	 */
	public static void convert(String string) {
		Set<String> set = new HashSet<String>();
		string = string.replaceAll("\\s", "");

		for (int count = 0; count < string.length(); count++) {
			set.add("" + string.charAt(count));

		}
		String string2[] = new String[set.size()];
		int val = 0;
		for (String str : set) {
			for (int count = 0; count < string.length(); count++) {

				if (str.equals(string.charAt(count) + "")) {
					if (string2[val] != null)
						string2[val] = string2[val] + ","
								+ string.indexOf(str, count);
					else
						string2[val] = str + " = "
								+ string.indexOf(str, count);
				}
			}
			val++;
		}

		for (int count = 0; count < string2.length; count++)
			System.out.println(string2[count]);

	}
}
