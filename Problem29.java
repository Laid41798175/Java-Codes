package projectEuler;

import java.math.BigInteger;

public class Problem29 {

	public static void main(String[] args) {

		int maxAB = 100;
		BigInteger[] arr = new BigInteger[(maxAB - 1) * (maxAB - 1)];

		for (int i = 2; i <= maxAB; i++) {
			BigInteger a = BigInteger.valueOf(i);
			for (int b = 2; b <= maxAB; b++) {
				BigInteger power = BigInteger.ONE;
				for (int k = 0; k < b; k++) {
					power = power.multiply(a);
				}

				arr[(i - 2) * (maxAB - 1) + (b - 2)] = power;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i].compareTo(arr[j]) == 0) {
					System.out.println("arr[" + i + "] is equal to arr[" + j + "] as " + arr[i].toString());
					arr[i] = BigInteger.ZERO;
					j = i;
				}
			}
		}

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals(BigInteger.ZERO)) {
				count++;
				System.out.println(arr[i].toString());
			}
		}
		System.out.println(count);
	}

}
