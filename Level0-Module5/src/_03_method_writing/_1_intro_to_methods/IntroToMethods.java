package _03_method_writing._1_intro_to_methods;

public class IntroToMethods {
	/*
	 * 3 parts to a method
	 * 
	 * 1) Method Name
	 * 		Used to call the method
	 * 		Always directly to the left of ()
	 * 2) Return type
	 * 		The type of value returned by the method (ex: int, String, boolean)
	 * 		"void" is a return type that returns nothing (like the move() for a Robot)
	 * 		Always directly to the left of the method name 
	 * 3) Parameters
	 * 		The values/variables passed into a method to be used
	 * 		Always inside the ()
	 * 
	 * Extra Note: "public" is optional and use "static" if calling the method from main
	 * 
	 * 
	 * Instructions
	 * ------------
	 * RUN THE CODE
	 * LOOK AT THE CODE BELOW
	 * FIGURE OUT THE 3 PARTS TO EACH METHOD
	 */
	public static void main(String[] args) {
		// Method1
		method1();

		// Method2
		String output2 = method2();
		System.out.println(output2);

		// Method3
		method3("Method3");
		
		// Method4
		String output4 = method4("Method4");
		System.out.println(output4);
		
		// Method5
		method5("Method", 5);
	}
	
	public static void method1() {
		System.out.println("Method1");
	}

	public static String method2() {
		return "Method2";
	}

	public static void method3(String message) {
		System.out.println("Method3");
	}

	public static String method4(String message) {
		return message;
	}
	
	public static void method5(String message, int num) {
		System.out.println(message+num);
	}
}
