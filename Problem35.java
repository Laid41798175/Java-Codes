package projectEuler;

public class Problem35 {
	
	static boolean[] arr = new boolean[1000000];

	public static void main(String[] args) {
		

		for (int i = 2; i < arr.length; i++) {
			arr[i] = isPrime(i);
		}
		
		int count = 0;
		for (int i = 2; i <arr.length; i++) {
			if (isCircularPrime(i)) {
				count++;
				System.out.println(i + " is a Circular prime number.");
			}
		}
		System.out.println(count);

	}

	public static boolean isCircularPrime(int n) {
		
		String str = Integer.toString(n);
		int n2 = n;
		for (int i = 0; i < str.length(); i++) {
			if (!arr[n2]) {
				return false;
			}
			int last = n2 % 10;
			last *= Math.pow(10, str.length() - 1);
			n2 /= 10;
			n2 += last;
		}
		return true;
	}

	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
