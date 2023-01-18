package projectEuler;

public class Problem34 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 3; i < 10000000; i++) {
			sum += check(i);
		}
		System.out.println("sum: " + sum);
	}

	public static int check(int n) {
		String str = Integer.toString(n);
		String[] arr = str.split("");
		int digit = str.length();
		int sum = 0;
		for (int i = 0; i < digit; i++) {
			sum += factorial(Integer.valueOf(arr[i]));
			if (sum > n) {
				return 0;
			}
		}

		if (sum == n) {
			System.out.println(sum);
			return n;
		}
		return 0;
	}

	public static int factorial(int n) {
		switch (n) {
		case 0:
			return 1;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 6;
		case 4:
			return 24;
		case 5:
			return 120;
		case 6:
			return 720;
		case 7:
			return 5040;
		case 8:
			return 40320;
		case 9:
			return 362880;
		default:
			return 0;
		}
	}

}
