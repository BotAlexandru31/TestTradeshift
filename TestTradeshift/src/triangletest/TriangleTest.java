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
		Scanner userInput = null;
		Triangle triangle = new Triangle();
		String resultFromCheck = TriangleUtils.getUserInput(triangle, userInput);
		if (resultFromCheck.equals("ok")) {
			TriangleUtils.checkTriangleType(triangle);

		} else {
			try {
				System.out.println("Check user input failed. Would you like to enter new values?(y/n)");
				System.out.println("before scanner");
				Scanner newScanner = new Scanner(System.in);
				if (newScanner.hasNextLine()) {
					repeatString = newScanner.nextLine();
					if ("y".equals(repeatString)) {
						main(args);
					} else {
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
					System.out.println("closing repeatInput");
					userInput.close();
				}
			}
		}
	}
}