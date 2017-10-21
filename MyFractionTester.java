package myMath;

import static org.junit.Assert.*;
import org.junit.Test;
import myMath.MyFraction;

public class MyFractionTester {

	@Test
	public void testMyFractionNumerator() {
		int numerator = 5;
		int denominator = 10;
		char sign = '+';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertEquals(v.getNumerator(), 5);
	}
	
	@Test
	public void testMyFractionDenominator() {
		int numerator = 5;
		int denominator = 10;
		char sign = '+';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertEquals(v.getDenominator(), 10);
	}
	
	@Test
	public void testMyFractionSign() {
		int numerator = 5;
		int denominator = 10;
		char sign = '+';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertEquals(v.getSign(), '+');
	}

	@Test
	public void testMyFractionSignNegative() {
		int numerator = 5;
		int denominator = 10;
		char sign = '-';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertEquals(v.getSign(), '-');
	}
	
	@Test
	public void testMyFractionPositive() {
		int numerator = 5;
		int denominator = 10;
		char sign = '+';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertEquals(v.toString(), "5/10");
	}
	
	@Test
	public void testMyFractionNegative() {
		int numerator = 5;
		int denominator = 10;
		char sign = '-';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertEquals(v.toString(), "-5/10");
	}
	
	@Test
	public void testMyFractionAddition() {
		int numerator = 27;
		int denominator = 90;
		char sign = '-';
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = new MyFraction(1, 5, '+');
		assertTrue((test.add(v)).equals(answer));
	}
	
	@Test
	public void testMySubtraction() {
		int numerator = 27;
		int denominator = 90;
		char sign = '-';
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = new MyFraction(4, 5, '+');
		assertTrue((test.subtract(v)).equals(answer));
	}
	
	@Test
	public void testMySubtraction2() {
		int numerator = 27;
		int denominator = 90;
		char sign = '-';
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = v.subtract(test);
		MyFraction process = v.subtract(test);
		assertTrue(process.equals(answer));
	}
	
	@Test
	public void testMyReduce() {
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction answer = test.reduce();
		assertTrue(test.reduce().equals(answer));
	}
	
	@Test
	public void testMyReduce2() {
		MyFraction test = new MyFraction(5, 10, '-');
		MyFraction answer = test.reduce();
		assertTrue(test.reduce().equals(answer));
	}
	
	@Test
	public void testMyMultiplication() {
		int numerator = 27;
		int denominator = 90;
		char sign = '-';
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = v.multiply(test);
		MyFraction process = v.multiply(test);
		assertTrue(process.equals(answer));
	}
	
	@Test
	public void testMyUndefined(){
		int numerator = 27;
		int denominator = 0;
		char sign = '-';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertEquals(v.toString(), "undefined");
	}
	
	@Test
	public void testMyMultiplication2() {
		int numerator = 27;
		int denominator = 0;
		char sign = '-';
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = v.multiply(test);
		MyFraction process = v.multiply(test);
		assertEquals(process, answer);
	}
	
	@Test
	public void testMyFractionAddition2() {
		int numerator = 27;
		int denominator = 0;
		char sign = '-';
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = test.add(v);
		assertTrue((test.add(v)).equals(answer));
	}
	
	@Test
	public void testMyConstructorNotNull() {
		int numerator = 5;
		int denominator = 10;
		char sign = '+';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertNotNull(v.getNumerator());
	}
	
	@Test
	public void testMyConstructorNotNull2() {
		int numerator = 5;
		int denominator = 10;
		char sign = '+';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertNotNull(v.getDenominator());
	}
	
	@Test
	public void testMyConstructorNotNull3() {
		int numerator = 5;
		int denominator = 0;
		char sign = '+';
		MyFraction v = new MyFraction(numerator, denominator, sign);
		assertNotNull(v.getNumerator());
	}
	
	@Test
	public void testMyDivision() {
		int numerator = 27;
		int denominator = 90;
		char sign = '-';
		MyFraction test = new MyFraction(5, 10, '+');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = new MyFraction(5, 3, '-');
		assertTrue((test.divide(v)).equals(answer));
	}
	
	@Test
	public void testMyDivision2() {
		int numerator = 5;
		int denominator = 10;
		char sign = '+';
		MyFraction test = new MyFraction(27, 90, '-');
		MyFraction v = new MyFraction(numerator, denominator, sign);
		MyFraction answer = new MyFraction(3, 5, '-');
		assertTrue((test.divide(v)).equals(answer));
	}
}
