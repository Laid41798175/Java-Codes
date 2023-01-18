package projectEuler;

public class Problem16 {

	public static void main(String[] args) {
		int digit = (int) (Math.log10(2) * 1000);
		int a[] = new int[digit + 1];
		a[0] = 1;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < a.length; j++) {
				a[j] *= 2;
			}
			a = carry(a);
		}
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println(sum);
	}

	public static int[] carry(int n[]) {
		for (int i = 0; i < n.length; i++) {
			if (n[i] >= 10) {
				n[i] -= 10;
				n[i + 1] += 1;
			}
		}
		return n;
	}

}