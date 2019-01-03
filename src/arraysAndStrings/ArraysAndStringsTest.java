package arraysAndStrings;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;


class ArraysAndStringsTest {
	int[] testRow2 = {1};
	int[] testRow3a = {1, 2, 3};
	int[] testRow3b = {4, 5, 6};
	int[] testRow3c = {7, 8, 9};
	int[] testRow4a = {10, 0, 12};
	int[] testRow4b = {0, 0, 0};
	int[][] testArray1 = new int[][]{new int[] {}};
	int[][] testArray2 = {testRow2};
	int[][] testArray3 = {testRow3a, testRow3b, testRow3c};
	int[][] testArray4 = {testRow3a, testRow3b, testRow3c, testRow4b};
	int[][] testArray5 = {testRow3a, testRow3b, testRow3c, testRow4a};

	@Test
	void testMain() {

	}

	@Test
	void testIsUniqueA() {
		assertTrue(ArraysAndStrings.isUniqueA("abcde"));
		assertTrue(ArraysAndStrings.isUniqueA("a"));
		assertFalse(ArraysAndStrings.isUniqueA("abcda"));
		assertFalse(ArraysAndStrings.isUniqueA("aa"));
		assertFalse(ArraysAndStrings.isUniqueA("abbccda"));
	}

	@Test
	void testIsUniqueB() {
		assertTrue(ArraysAndStrings.isUniqueA("abcde"));
		assertTrue(ArraysAndStrings.isUniqueA("a"));
		assertFalse(ArraysAndStrings.isUniqueA("abcda"));
		assertFalse(ArraysAndStrings.isUniqueA("aa"));
		assertFalse(ArraysAndStrings.isUniqueA("abbccda"));
	}

	@Test
	void testIsPermutation() {
		assertTrue(ArraysAndStrings.isPermutation("a", "a"));
		assertTrue(ArraysAndStrings.isPermutation("ab", "ba"));
		assertTrue(ArraysAndStrings.isPermutation("hello world", "world hello"));
		assertFalse(ArraysAndStrings.isPermutation("a", "ab"));
		assertFalse(ArraysAndStrings.isPermutation("hello", "hellp"));
	}

	@Test
	void testURLify() {
		assertEquals(ArraysAndStrings.URLify("hello"), "hello");
		assertEquals(ArraysAndStrings.URLify("hello world"), "hello%20world");
		assertEquals(ArraysAndStrings.URLify(" hello  world "), "%20hello%20%20world%20");
	}

	@Test
	void testIsPalindromePermutation() {
		assertTrue(ArraysAndStrings.isPalindromePermutation("a"));
		assertTrue(ArraysAndStrings.isPalindromePermutation("aa"));
		assertTrue(ArraysAndStrings.isPalindromePermutation("abcdabcd"));
		assertTrue(ArraysAndStrings.isPalindromePermutation("abcdabcde"));
		assertFalse(ArraysAndStrings.isPalindromePermutation("ab"));
		assertFalse(ArraysAndStrings.isPalindromePermutation("abcdabcdabcd"));
	}

	@Test
	void testIsOneAway() {
		assertTrue(ArraysAndStrings.isOneAway("a", "a"));
		assertTrue(ArraysAndStrings.isOneAway("a", "ab"));
		assertTrue(ArraysAndStrings.isOneAway("ba", "b"));
		assertTrue(ArraysAndStrings.isOneAway("hello", "hellp"));
		assertTrue(ArraysAndStrings.isOneAway("hellp", "hello"));
		assertTrue(ArraysAndStrings.isOneAway("a", "a"));
		assertFalse(ArraysAndStrings.isOneAway("a", "abb"));
		assertFalse(ArraysAndStrings.isOneAway("hello", "heppo"));
	}

	@Test
	void testCompressString() {
		assertEquals(ArraysAndStrings.compressString("a"), "a");
		assertEquals(ArraysAndStrings.compressString("aa"), "aa");
		assertEquals(ArraysAndStrings.compressString("aaa"), "a3");
		assertEquals(ArraysAndStrings.compressString("aaabbbccc"), "a3b3c3");
	}

	@Test
	void testRotateImage() {
		int[] emptyArray = new int [0];
		int[][] emptyArrayComb = {emptyArray};
		int[] oneArray = {1};
		int[][] oneArrayComb = {oneArray};
		int[] test1 = {7, 4, 1};
		int[] test2 = {8, 5, 2};
		int[] test3 = {9, 6, 3};
		int[][] testRotated = {test1, test2, test3};

		ArraysAndStrings.rotateImage(testArray1);
		for(int i = 0; i < testArray1.length; i++) {
			assertArrayEquals(testArray1[i], emptyArrayComb[i]);
		}
		
		ArraysAndStrings.rotateImage(testArray2);
		for(int i = 0; i < testArray2.length; i++) {
			assertArrayEquals(testArray2[i], oneArrayComb[i]);
		}

		ArraysAndStrings.rotateImage(testArray3);
		for(int i = 0; i < testArray3.length; i++) {
			assertArrayEquals(testArray3[i], testRotated[i]);
		}
	}

	@Test
	void testZeroMatrix() {
		int[] test1 = {0, 0, 0};
		int[] test2 = {0, 0, 0};
		int[] test3 = {0, 0, 0};
		int[] test4 = {0, 0, 0};
		int[][] testZero1 = {test1, test2, test3, test4};
		
		int[] testRow3a = {1, 0, 3};
		int[] testRow3b = {4, 0, 6};
		int[] testRow3c = {7, 0, 9};
		int[] testRow4a = {0, 0, 0};
		int[][] testZero2 = {testRow3a, testRow3b, testRow3c, testRow4a};
		
		int[][] zeroed1 = ArraysAndStrings.zeroMatrix(testArray4);
		int[][] zeroed2 = ArraysAndStrings.zeroMatrix(testArray5);
		
		assertEquals(testZero1.length, zeroed1.length);
		assertEquals(testZero1[0].length, zeroed1[0].length);
		assertEquals(testZero2.length, zeroed2.length);
		assertEquals(testZero2[0].length, zeroed2[0].length);
		
		for(int i = 0; i < testZero1.length; i++) {
			assertArrayEquals(testZero1[i], zeroed1[i]);
		}
		
		for(int i = 0; i < testZero2.length; i++) {
			assertArrayEquals(testZero2[i], zeroed2[i]);
		}
	}

	@Test
	void testIsRotation() {
		assertTrue(ArraysAndStrings.isRotation("a", "a"));
		assertTrue(ArraysAndStrings.isRotation("ab", "ab"));
		assertTrue(ArraysAndStrings.isRotation("abc", "cab"));
		assertTrue(ArraysAndStrings.isRotation("bca", "abc"));
		assertFalse(ArraysAndStrings.isRotation("abc", "abcd"));
	}
}
