package triangletest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleUtils {

	public static String checkTriangleType(Triangle triangle) {
		String result = "";

		Double cathetus1 = triangle.getCathetus1();
		Double cathetus2 = triangle.getCathetus2();
		Double hypotenuse = triangle.getHypotenuse();
		System.out.println("The values are: "+triangle.toString());

		if (cathetus1.equals(hypotenuse) || cathetus1.equals(cathetus2) || hypotenuse.equals(cathetus2)) {
			result = TriangleType.ISOSCELES.toString();
		}

		if (!cathetus1.equals(cathetus2) && !cathetus2.equals(hypotenuse) && !hypotenuse.equals(cathetus1)) {
			result = TriangleType.SCALENE.toString();
		}

		if (cathetus1.equals(cathetus2) && cathetus2.equals(hypotenuse)) {
			result = TriangleType.EQUILATERAL.toString();
		}
		System.out.println("result: " + result);
		System.out.println("");

		return result;
	}

	public static String checkUserInput(Double cathetus1, Double cathetus2, Double hypotenuse) {
		System.out.println("<<entering method - checkUserInput - >>>");
		String message = null;

		if (cathetus1 > 0 && cathetus2 > 0 && hypotenuse > 0) {
			message = "ok";
		} else {
			message = "ko";
			System.out.println("Check failed! Values should be > 0.");

		}
		System.out.println("<<exiting method - checkUserInput - >>>");

		return message;

	}

	public static String getUserInput(Triangle triangle, Scanner userInput) {
		System.out.println("...getting user input");
		Double cathetus1 = 0D;
		Double cathetus2 = 0D;
		Double hypotenuse = 0D;
		String result = null;

		try {
			userInput = new Scanner(System.in);
			System.out.println(" Enter the value for the first cathetus:");
			cathetus1 = userInput.nextDouble();
			System.out.println(" Enter the value for the second cathetus: ");
			cathetus2 = userInput.nextDouble();
			System.out.println(" Enter the value for the hypotenuse: ");
			hypotenuse = userInput.nextDouble();
			String checkUserResult = checkUserInput(cathetus1, cathetus2, hypotenuse);
			if ("ok".equals(checkUserResult)) {
				System.out.println("setting values on triangle...");
				triangle.setCathetus1(cathetus1);
				triangle.setCathetus2(cathetus2);
				triangle.setHypotenuse(hypotenuse);
				result = "ok";
			} else {
				result = "ko";
			}

		} catch (InputMismatchException inputMismatchEx) {
			System.out.println("Please enter a number. [" + inputMismatchEx.getCause() + "]");
			if (userInput != null) {
				System.out.println("closing userInput");
				userInput.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (userInput != null) {
				System.out.println("closing userInput");
				userInput.close();
			}
		}

		return result;
	}

}
