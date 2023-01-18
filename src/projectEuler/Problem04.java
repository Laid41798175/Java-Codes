package projectEuler;

public class Problem04 {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					int m = 100001 * i + 10010 * j + 1100 * k;
					for (int a = 100; a < 1000; a++) {
						for (int b = 100; b < a; b++) {
							if (a * b == m) {
								System.out.println(m);
							}
						}
					}
				}
			}
		}
	}
}