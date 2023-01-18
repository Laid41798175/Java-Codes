package projectEuler;

public class Problem20 {

	public static void main(String[] args) {
		double a = 0;
		for (int i = 1; i <= 100; i++) {
			a += Math.log10(i);
		}
		int dig = (int) a + 1;
		int digit[] = new int[dig + 2];
		for (int i = 0; i < digit.length; i++) {
			digit[i] = 0;
		}
		digit[0] = 1;
		for (int i = 100; i > 0; i--) {
			for (int j = 0; j < digit.length; j++) {
				digit[j] *= i;
			}
			for (int j = 0; j < dig; j++) {
				digit[j + 2] += (digit[j] - digit[j] % 100) / 100;
				digit[j] %= 100;
				digit[j + 1] += (digit[j] - digit[j] % 10) / 10;
				digit[j] %= 10;
			}
		}
		int sum = 0;
		for (int i = 0; i < digit.length; i++) {
			sum += digit[i];
		}
		System.out.println(sum);
	}

}