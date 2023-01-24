package primeNumbers;

import java.util.Arrays;

public class Ex3 {

	static long start;
	static long end;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		int[] arr = primes(1234567);
		end = System.currentTimeMillis();
		printArray(arr);
		printTime();
	}

	static int[] primes(int end) {
		int[] arr = new int[end]; // 소수가 end개를 넘지 않음
		int index = 0;
		for (int i = 1; i <= end; i++) {
			if (isPrime(i))
				arr[index++] = i;
		}
		return Arrays.copyOf(arr, index);
	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	static void printTime() {
		System.out.println((end - start) + "ms");
	}

	static StringBuilder sb = new StringBuilder();

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.print(sb);
	}

}
