package primeNumbers;

public class Ex1 {

	static long start;
	static long end;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		System.out.println(isPrime(123456789));
		end = System.currentTimeMillis();
		printTime();
	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		int count = 0;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				count++;
		}
		return count == 0;

	}

	static void printTime() {
		System.out.println((end - start) + "ms");
	}
}