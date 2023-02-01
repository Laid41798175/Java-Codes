package projectEuler;

import java.util.ArrayList;

public class Problem51 {

	public static void main(String[] args) {
		primeNumbers = new ArrayList<>();

		for (int i = 1; i < 1000000; i++) {
			makePrimeNumbers(i);
		}

		for (int i = 100000; i < 1000000; i++) {
			if (isPrime(i)) {
				if (checkDigitReplacement(i)) {
					return;
				}
			}
		}
	}

	static ArrayList<Integer> primeNumbers;

	public static void makePrimeNumbers(int num) {
		if (num == 1)
			return;
		if (num == 2) {
			primeNumbers.add(num);
			return;
		}

		int pivot = 1;
		for (int i = 0; pivot <= Math.sqrt(num); i++) {
			if (num % primeNumbers.get(i) == 0) {
				return;
			}
			pivot = primeNumbers.get(i);
		}
		primeNumbers.add(num);
	}

	public static boolean isPrime(int num) {
		if (num == 1)
			return false;
		if (num == 2) {
			return true;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static boolean checkDigitReplacement(int num) {
		int digit = Integer.toString(num).length();
		int pow = (int) Math.pow(2, digit);
		boolean[] digits = new boolean[digit];

		for (int i = 1; i < pow; i++) {
			String str = Integer.toBinaryString(i);
			int diff = digit - str.length();
			for (int j = 0; j < digit; j++) {
				if (j < diff) {
					digits[j] = false;
				} else {
					if (str.charAt(j - diff) == '0') {
						digits[j] = false;
					} else {
						digits[j] = true;
					}
				}
			}

			if (checkReplacement(num, digits)) {
				System.out.println(num);
				return true;
			}
		}
		return false;
	}

	public static boolean checkReplacement(int num, boolean[] digits) {
		int count = 0;
		String str = "";
		for (int i = 0; i <= 9; i++) {
			int rep = replace(num, digits, i);
			if (100000 < rep && isPrime(rep)) {
				str = str.concat(String.valueOf(rep) + " ");
				count++;
			}
		}

		if (count >= 8) {
			System.out.println(num + ": " + count);
			System.out.println(str);
			return true;
		} else {
			return false;
		}
	}

	public static int replace(int num, boolean[] digits, int i) {
		String str = Integer.toString(num);
		char[] chs = str.toCharArray();
		for (int j = 0; j < str.length(); j++) {
			if (digits[j]) {
				chs[j] = (char) (i + '0');
			}
		}
		return Integer.valueOf(String.valueOf(chs));
	}

}