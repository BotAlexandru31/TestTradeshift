package triangletest;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TriangleTest {
	//test class
	
	public static void main(String[] args) {
		testTriangle(args);
	}
	
	/*
	 * test method
	 * calls TriangleUtils.setUserInput(triangle, userInput)
	 * if returned string is "ok" it will continue by checking the type of the Triangle
	 * otherwise it will ask the user for another set of input values
	 * if the answer is "y" then the program will allow the user for another set of values and continue with checking the triangle type.
	 * 
	 * exception handling: in case of inserting characters instead of numbers
	 * 
	 * at the end it will close the scanner for resource saving.
	 */
	public static void testTriangle(String[] args) {
		String repeatString = null;
		Scanner userInput = new Scanner(System.in);
		Triangle triangle = new Triangle();
		String resultFromCheck = TriangleUtils.setUserInput(triangle, userInput);
		try {
		if (resultFromCheck.equals("ok")) {
			TriangleUtils.checkTriangleType(triangle);
		} else {
			
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
			}
			} catch (InputMismatchException inputMismatchEx) {
				System.out.println("Please enter a number. [" + inputMismatchEx.getCause() + "]");
			} catch (NoSuchElementException noElem) {
				System.out.println(noElem.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if (userInput != null) {
					System.out.println("closing userInput scanner");
					userInput.close();
				}
			}
		}
	}