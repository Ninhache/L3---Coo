package fr.main.java.util;

/**
 * 
 * @author neo.almeida.etu@univ-lille.fr
 *
 */
public class Math {

	/**
	 * Return true if the number passed in parameter is a power of two
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPowerOfTwo(int number) {
		return (number != 0) && ((number & (number - 1)) == 0);
	}

	/**
	 * Return true if the number is included in the probability's threshold
	 * @param value
	 * @param probability
	 * @param threshold
	 * @return
	 */
	public static boolean inTreshold(double value, double probability, double threshold) {
		return (probability - threshold) < value && value < (probability + value) ; 
	}
	
}
