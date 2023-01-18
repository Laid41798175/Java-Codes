package projectEuler;

public class Problem05 {

	public static void main(String[] args) {
		for (int i = 1;; i++) {
			for (int j = 2;; j++) {
				if (i % j == 0) {
					if (j == 20) {
						System.out.println(i);
						System.exit(1);
					}
				} else
					break;
			}
		}
	}

}