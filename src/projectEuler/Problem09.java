package projectEuler;

public class Problem09 {

	public static void main(String[] args) {
		int c;
		for (int a = 1; a < 999; a++) {
			for (int b = 1; b < a; b++) {
				c = 1000 - a - b;
				if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
					System.out.println(a * b * c);
				}
			}
		}
	}

}