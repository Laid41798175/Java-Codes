package primeNumbers;

import java.util.Arrays;

public class ExOverload {

	static long start;
	static long end;
	
	static boolean[] isPrime;
	static int[] list;
	static int count;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		int[] arr = primes(500_000, 1_000_000);
		end = System.currentTimeMillis();
		printArray(arr);
		printTime();
	}

	//TODO, Overloading
	static int[] primes(int start, int end) { // start <= end is guaranteed
		int[] ret = new int[1]; // You may erase this line
		// TODO
		return ret; // You may erase this line
	}
	
	static int[] primes(int end) {
		boolean[] isPrime = new boolean[end + 1];
		int[] arr = new int[end];
		Arrays.fill(isPrime, true);
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
