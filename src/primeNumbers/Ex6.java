package primeNumbers;

import java.util.Arrays;

public class Ex6 { // primeFactorization with isPrime[]

	static long start;
	static long end;
	
	static boolean[] isPrime;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)  {
		start = System.currentTimeMillis();
		primeFactorization(1435494919);
		end = System.currentTimeMillis();
		printTime();
	}

	static void primeFactorization(int n) {
		isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		int i = 2;
		while (n != 1) {
			if (!isPrime[i]) {
				i++;
				continue;
			}
			
			while (n % i == 0) {
				n /= i;
				for (int j = 2 * i; j <= n; j += i) {
					isPrime[j] = false;
				}
				sb.append(i + "\n");
			}
			
			i++;
		}		
		System.out.print(sb);
	}
	
	static void printTime() {
		System.out.println((end - start) + "ms");
	}
	
}