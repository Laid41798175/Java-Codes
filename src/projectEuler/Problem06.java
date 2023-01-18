package projectEuler;

public class Problem06 {

	public static void main(String[] args) {
		int n = 100;
		int a = 0;
		for (int i = 1; i <= n; i++) {
			a += (int) Math.pow(i, 2);
		}
		int b = 0;
		for (int i = 1; i <= n; i++) {
			b += i;
		}
		b*=b;
		if (a >= b) {
			System.out.println(a - b);
		} else {
			System.out.println(b - a);
		}
	}

}