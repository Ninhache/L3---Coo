package fr.main.java.util;

public class Math {

	/**
	 *	Return true if the number passed in parameter is a power of two
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPowerOfTwo(int number) {
		return (number != 0) && ((number & (number - 1)) == 0);
	}
	
}
