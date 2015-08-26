import java.util.Scanner;

public class GetDataFromUser {

	private Scanner scanner;
	private Scanner scanner2;
	private Scanner scanner3;
	private Scanner scanner1;

	/**
	 * taking mail from user and check it same time
	 * 
	 * @return string of mail
	 */
	String checkMail() {
		scanner = new Scanner(System.in);
		String mail;
		System.out.println("enter the mail id of person");
		mail = scanner.nextLine();
		if (mail.contains("@") && mail.contains(".com")) {
			return mail;
		} else {
			mail = checkMail();
		}
		return mail;
	}

	/**
	 * taking mobile number from user and check it same time
	 * 
	 * @return
	 */
	String checkNumber() {
		scanner2 = new Scanner(System.in);
		String number;
		System.out.println("enter the mobile number of person");
		number = scanner2.next();
		if (number.length() == 10) {
			return number;
		} else {
			number = checkNumber();
			return number;
		}
	}

	/**
	 * get person name from user
	 * 
	 * @return string of name
	 */
	String getPersonName() {
		scanner3 = new Scanner(System.in);
		String name;
		System.out.println("enter name of person");
		name = scanner3.nextLine();
		return name;
	}

	/**
	 * getting the all person detail from user
	 * 
	 * @return
	 */
	public Person getPersonDetail() {
		String mail = checkMail();
		scanner1 = new Scanner(System.in);
		System.out.println("enter the name of person");
		String name = scanner1.nextLine();
		String phoneNo = checkNumber();
		System.out.println("enter school name of person");
		String schoolName = scanner1.nextLine();
		System.out.println("enter the college name of person");
		String collegeName = scanner1.nextLine();
		Person person = new Person();
		person.setName(name);
		person.setCollegeName(collegeName);
		person.setEmailId(mail);
		person.setPhoneNumber(phoneNo);
		person.setSchoolName(schoolName);
		return person;
	}
}
