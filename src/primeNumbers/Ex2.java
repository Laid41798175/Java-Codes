package primeNumbers;

import java.util.Arrays;

public class Ex2 {

	static long start;
	static long end;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		boolean b = isPrime(123456789);		
		end = System.currentTimeMillis();
		System.out.println(b);
		printTime();
	}

	static boolean isPrime(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i])
				continue;
			else {
				for (int j = 2 * i; j <= n; j += i) {
					isPrime[j] = false;
					if (j == n) {
						// return false;
					}
				}					
			}
		}		
		return isPrime[n];
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
