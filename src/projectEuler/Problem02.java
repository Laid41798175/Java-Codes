package projectEuler;

public class Problem02 {

	public static void main(String[] args) {
		int count = 0;
		int a = 1;
		int b = 1;
		int c = a + b;
		while (c < 4000000) {
			count += c;
			a = b + c;
			b = c + a;
			c = b + a;
		}
		System.out.println(count);
	}

}
