package _08_string_methods;
//    Copyright (c) The League of Amazing Programmers 2013-2017
//    Level 0



public class StringMethods {
	public static void main(String[] args) {
		
		// 1. Create a String variable and initialize it to whatever you want
		String string = "abc";
		// 2. Print the 3rd char of your String to the console.
		//    HINT: .charAt
		System.out.println(string.charAt(2));
		// 3. Print the length of your String to the console.
		//    HINT: .length()
		System.out.println(string.Length());
		// 4. Using a for loop, print one char at time to the console.
		//    HINT: use .length() to determine how many loops
		//for (int i = 0; i < string.length() ; i ++){
			
		// 5. Pick a char inside your String, and use a loop to determine
		//    what position/index in the String the char is located.
		//    Print the char's position to the console.
		//    EXAMPLE: if your string is "abc" and you are searching 
		//             for char 'b', then print "b is at index 1"
		
		for( int i = 0; i < string.length(); i++){
			    if(string.charAt(i) == 'b'){
				    System.out.println("b is at index " + i);
			    }
		    }	
	}
}


