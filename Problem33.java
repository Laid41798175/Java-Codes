package projectEuler;

public class Problem33 {

	public static void main(String[] args) {
		for (int j = 11; j < 100; j++) {
			for (int i = 10; i < j; i++) {
				if (check(i, j)) { // i < j
					System.out.println(i + "/" + j);
				}
			}
		}
	}

	public static boolean check(int a, int b) { // a < b
		int a1 = a / 10;
		int a2 = a % 10;
		int b1 = b / 10;
		int b2 = b % 10;

		if (a1 == b2) {
			if (a2 * b == a * b1) {
				return true;
			}
		} else if (a2 == b1) {
			if (a1 * b == a * b2) {
				return true;
			}
		}
		return false;
	}
}
