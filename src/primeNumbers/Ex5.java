package primeNumbers;

public class Ex5 { // primeFactorization with isPrime()

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
		int i = 2;
		while (n != 1) {
			if (!isPrime(i)) {
				i++;
				continue;
			}
			
			while (n % i == 0) {
				n /= i;
				sb.append(i + "\n");
			}
			i++;
		}		
		System.out.print(sb);
	}
	
	static boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	static void printTime() {
		System.out.println((end - start) + "ms");
	}
	
}