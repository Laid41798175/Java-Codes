package primeNumbers;

import java.util.Arrays;

public class Ex7 { // primeFactorization with primes()

	static long start;
	static long end;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)  {		
		start = System.currentTimeMillis();
		primeFactorization(1435494919);
		end = System.currentTimeMillis();
		printTime();
	}

	static void primeFactorization(int n) {
		int[] arr = primes((int) Math.sqrt(n));
		for (int i = 0; i < arr.length; i++) {
			while (n % arr[i] == 0) {
				n /= arr[i];
				sb.append(arr[i] + "\n");
			}
			if (n == 1) {
				System.out.print(sb);
				return;
			}
		}
		sb.append(n + "\n");
		System.out.print(sb);
		return;
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
	
}