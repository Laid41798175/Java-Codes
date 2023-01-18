package projectEuler;

public class Problem37 {

	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		int i = 11;
		while (count < 11) {
			if (isTruncatable(i)) {
				System.out.println(i);
				sum += i;
				count++;
			}
			i += 2;
		}

		System.out.println(sum);
	}

	public static boolean isTruncatable(int n) {
		String str = Integer.toString(n);
		for (int i = 0; i < str.length(); i++) {
			if (!isPrime(Integer.valueOf(str.substring(0, i + 1)))) {
				return false;
			}
			if (!isPrime(Integer.valueOf(str.substring(i, str.length())))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
