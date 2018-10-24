package triangletest;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TriangleTest {

	public static void main(String[] args) {
		testTriangle(args);
	}

	public static void testTriangle(String[] args) {
		String repeatString = null;
		Scanner userInput = new Scanner(System.in);
		Triangle triangle = new Triangle();
		String resultFromCheck = TriangleUtils.setUserInput(triangle, userInput);
		if (resultFromCheck.equals("ok")) {
			TriangleUtils.checkTriangleType(triangle);
		} else {
			try {
				System.out.println("Values were inserted incorrectly. Would you like to enter new values?(y/n)");
				if (userInput.hasNextLine()) {
					repeatString = userInput.nextLine();
					if ("y".equals(repeatString)) {
						main(args);
					} 
					else {
						System.exit(0);
					}
				}
			} catch (InputMismatchException inputMismatchEx) {
				System.out.println("Please enter a number. [" + inputMismatchEx.getCause() + "]");
			} catch (NoSuchElementException noElem) {
				System.out.println(noElem.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if (userInput != null) {
					System.out.println("closing userInput");
					userInput.close();
				}
			}
		}
	}
}