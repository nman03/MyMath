package myMath;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class MySetTester {

	@Test
	public void testMySetCreated() {
		int[] array = {1, 2, 3, 4 };
		MySet test = new MySet(array);
		assertNotNull(test);
	}
	
	@Test
	public void testMySetClearDuplicates() {
		int[] array = {1, 1, 1, 1, 2, 2, 3, 4, 4, 5};
		int[] answerArray = {1, 2, 3, 4, 5};
		MySet test = new MySet(array);
		boolean equal;
		
		if ((test instanceof MySet) && (Arrays.equals(test.getSetArray(), answerArray))) {
            equal = true;
        } else {
            equal = false;
        }
		
		assertTrue(equal);
	}
	
	@Test
	public void testGetSetArray() {
		int[] array = {2, 4, 6, 8};
		MySet test = new MySet(array);
		boolean equal;
		
		if ((test instanceof MySet) && (Arrays.equals(test.getSetArray(), array))) {
            equal = true;
        } else {
            equal = false;
        }
		
		assertTrue(equal);	
	}

	@Test
	public void testAdd() {
		int[] array1 = {3, 3, 2, 4, 6, 8, 9, 0, 8, 7, 12, 11, 15};
		int[] array2 = {4, 1, 2, 4, 5, 6, 7, -8, 5, 4, 1, 9, 6}; 		
		int[] answerArray = {3, 0, 8, 12, 11, 15, 2, 7, -8, 5, 4, 1, 9, 6};
		MySet set1 = new MySet(array1);
		MySet set2 = new MySet(array2);
		MySet answer = new MySet(answerArray);
		boolean equal;
		
		if ((set1.add(set2) instanceof MySet) && (Arrays.equals(set1.add(set2).getSetArray(), answer.getSetArray()))) {
            equal = true;
        } else {
            equal = false;
        }
		
		assertTrue(equal);
	}

	@Test
	public void testSubtract() {
		int[] array1 = {0, 1, 2, 3, 3, 5, 5};
		int[] array2 = {3, 3, 4, 6, 8, 1}; 		
		int[] answerArray = {0, 2, 5};
		MySet set1 = new MySet(array1);
		MySet set2 = new MySet(array2);
		MySet answer = new MySet(answerArray);
		boolean equal;
		
		if ((set1.subtract(set2) instanceof MySet) && (Arrays.equals(set1.subtract(set2).getSetArray(), answer.getSetArray()))) {
            equal = true;
        } else {
            equal = false;
        }
		
		assertTrue(equal);
	}
	
	@Test
	public void testSubtract2() {
		int[] array1 = {0, 1, 2, 3, 3, 5, 5};
		int[] array2 = {3, 3, 4, 6, 8, 1}; 		
		int[] answerArray = {4, 6, 8};
		MySet set1 = new MySet(array1);
		MySet set2 = new MySet(array2);
		MySet answer = new MySet(answerArray);
		boolean equal;
		
		if ((set2.subtract(set1) instanceof MySet) && (Arrays.equals(set2.subtract(set1).getSetArray(), answer.getSetArray()))) {
            equal = true;
        } else {
            equal = false;
        }
		
		assertTrue(equal);
	}

	@Test
	public void testDivide() {
		int[] array1 = {5, 3, 5, 6, 6, 8, 89, 4, 2};
		int[] array2 = {4, 5, 7, 7, 9, 11, 54, 6, 6}; 		
		int[] answerArray = {5, 6, 4};
		MySet set1 = new MySet(array1);
		MySet set2 = new MySet(array2);
		MySet answer = new MySet(answerArray);
		boolean equal;
		
		if ((set1.divide(set2) instanceof MySet) && (Arrays.equals(set1.divide(set2).getSetArray(), answer.getSetArray()))) {
            equal = true;
        } else {
            equal = false;
        }
		
		assertTrue(equal);
	}

	@Test
	public void testMultiply() {
		int[] array1 = {5, 3, 5, 6, 6, 8, 89, 4, 2};
		int[] array2 = {4, 5, 7, 7, 9, 11, 54, 6, 6}; 		
		int[] answerArray = {3, 8, 89, 2, 7, 9, 11, 54};
		MySet set1 = new MySet(array1);
		MySet set2 = new MySet(array2);
		MySet answer = new MySet(answerArray);
		boolean equal;
		
		if ((set1.multiply(set2) instanceof MySet) && (Arrays.equals(set1.multiply(set2).getSetArray(), answer.getSetArray()))) {
            equal = true;
        } else {
            equal = false;
        }
		
		assertTrue(equal);
	}

	@Test
	public void testToString() {
		int[] array = {1, 3, 5, 7, 9};
		MySet test = new MySet(array);
		assertEquals(test.toString(), "{1, 3, 5, 7, 9}");
	}
	
	@Test 
	public void testMySetEmpty() {
		int[] array = {};
		MySet test = new MySet(array);
		assertEquals(test.toString(), "Empty");
	}
}
