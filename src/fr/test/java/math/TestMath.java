package fr.test.java.math;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import fr.main.java.util.Math;

public class TestMath {
	
	@Test
	public void testIsPowerOfTwo() {
		assertTrue(Math.isPowerOfTwo(1));
		assertTrue(Math.isPowerOfTwo(2));
		assertTrue(Math.isPowerOfTwo(4));
		
	}
	
	@Test
	public void testIsNotPowerOfTwo() {
		assertFalse(Math.isPowerOfTwo(255));
		assertFalse(Math.isPowerOfTwo(100));
		assertFalse(Math.isPowerOfTwo(-1));
	}
	
}
