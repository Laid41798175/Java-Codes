package primeNumbers;

public class Ex0 {

	static long start;
	static long end;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		System.out.println(isPrime(123456789));
		end = System.currentTimeMillis();
		printTime();
	}

	static boolean isPrime(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				count++;
		}
		return count == 2;
	}

	static void printTime() {
		System.out.println((end - start) + "ms");
	}
}
