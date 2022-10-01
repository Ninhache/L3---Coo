package fr.main.java.util;

public class Math {

	public static boolean isPowerOfTwo(int number) {
		return (number != 0) && ((number & (number - 1)) == 0);
	}
	
}
