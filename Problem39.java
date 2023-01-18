package projectEuler;

public class Problem39 {

	public static void main(String[] args) {
		int max = 0;
		int maxi = 0;
		for (int i = 1; i < 1000; i++) {
			if (solutions(i) > max) {
				max = solutions(i);
				maxi = i;
			}
		}
		System.out.println(maxi + " " + max);
	}

	public static int solutions(int n) {
		int count = 0;
		for (int a = 1; a < n / 3; a++) {
			for (int b = a; b < n / 2; b++) {
				if (isRight(a, b, n - a - b, n)) {
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isRight(int a, int b, int c, int n) {
		if (a + b + c != n)
			return false;
		return a * a + b * b == c * c;
	}
}
