package primeNumbers;

import java.util.Arrays;

public class Ex4 {

	static long start;
	static long end;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		int[] arr = primes(100);
		end = System.currentTimeMillis();
		printArray(arr);
		printTime();
	}

	static int[] primes(int end) {
		boolean[] isPrime = new boolean[end + 1];
		int[] arr = new int[end];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i <= end; i++) {
			if (!isPrime[i])
				continue;
			else {
				for (int j = 2 * i; j <= end; j += i)
					isPrime[j] = false;
			}
		}
		
		int index = 0;		
		for (int i = 1; i <= end; i++) {
			if (isPrime[i])
				arr[index++] = i;
		}
		
		return Arrays.copyOf(arr, index);
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
