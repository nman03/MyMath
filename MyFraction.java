package myMath;

public class MyFraction implements MyMath<MyFraction>{
	private int numerator;
	private int denominator;
	private char sign;

	public MyFraction(int numerator, int denominator, char sign) {
		this.numerator = numerator;
		this.denominator = denominator;
		this.sign = sign;

	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public char getSign() {
		return sign;
	}

	public MyFraction reduce() {
		int num = getNumerator();
		int den = getDenominator();
		boolean keepLooking = true;

		if (den == 0) {

		} else if (num == 0) {
			den = 1;
		} else if (den > num) {
			for (int i = getNumerator(); keepLooking ; i--) {
				if (den % i == 0 && num % i == 0) {
					den /= i;
					num /= i;
					keepLooking = false;
				}
			}
		} else if (num > den) {
			for (int i = getDenominator(); keepLooking ; i--) {
				if (den % i == 0 && num % i == 0) {
					den /= i;
					num /= i;
					keepLooking = false;
				}
			}
		} else {
			num = 1;
			den = 1;
		}

		return new MyFraction(num, den, getSign()) ;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof MyFraction) && (((MyFraction) o).getNumerator() == this.numerator) && (((MyFraction) o).getDenominator() == this.denominator) && (((MyFraction) o).getSign() == this.sign)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public MyFraction add(MyFraction o) {
		int commonDenominator = getDenominator() * o.getDenominator();
		int sumOfNumerators, numerator1, numerator2;
		char signOfAnswer;

		if (getSign() == '-') {
			numerator1 = -1 * getNumerator();
		} else {
			numerator1 = getNumerator();
		}

		if (o.getSign() == '-') {
			numerator2 = -1 * o.getNumerator();
		} else {
			numerator2 = o.getNumerator();
		}

		sumOfNumerators = (o.getDenominator() * numerator1) + (getDenominator() * numerator2);

		if (sumOfNumerators < 0) {
			signOfAnswer = '-';
		} else {
			signOfAnswer = '+';
		}

		return (new MyFraction(Math.abs(sumOfNumerators), commonDenominator, signOfAnswer)).reduce();
	}

	@Override
	public MyFraction subtract(MyFraction o) {
		int commonDenominator = getDenominator() * o.getDenominator();
		int diffOfNumerators, numerator1, numerator2;
		char signOfAnswer;

		if (getSign() == '-') {
			numerator1 = -1 * getNumerator();
		} else {
			numerator1 = getNumerator();
		}

		if (o.getSign() == '-') {
			numerator2 = -1 * o.getNumerator();
		} else {
			numerator2 = o.getNumerator();
		}

		diffOfNumerators = (o.getDenominator() * numerator1) - (getDenominator() * numerator2);

		if (diffOfNumerators < 0) {
			signOfAnswer = '-';
		} else {
			signOfAnswer = '+';
		}

		return (new MyFraction(Math.abs(diffOfNumerators), commonDenominator, signOfAnswer)).reduce();

	}

	@Override
	public MyFraction divide(MyFraction o) {
		char signOfAnswer;

		if (getSign() == o.getSign()) {
			signOfAnswer = '+';
		} else {
			signOfAnswer = '-';
		}

		if (o.getNumerator() == 0) {

		}

		return (new MyFraction(getNumerator() * o.getDenominator(), getDenominator() * o.getNumerator(), signOfAnswer)).reduce();
	}

	@Override
	public MyFraction multiply(MyFraction o) {
		char signOfAnswer;

		if (getSign() == o.getSign()) {
			signOfAnswer = '+';
		} else {
			signOfAnswer = '-';
		}

		return (new MyFraction(getNumerator() * o.getNumerator(), getDenominator() * o.getDenominator(), signOfAnswer)).reduce();
	}

	public String toString() {
		String output;

		if (getDenominator() == 0) {
			output = "undefined";
		} else if (getSign() == '+' || getNumerator() == 0) {
			output = "" + numerator + "/" + denominator;
		}
		else {
			output = "-" + numerator + "/" + denominator; 
		}

		return output;   
	}
}
