package projectEuler;

public class Problem21 {

	public static void main(String[] args) {
		int dn[] = new int[10001];
		for (int i = 1; i < dn.length; i++) {
			dn[i] = dn(i);
		}
		int sum = 0;
		for (int i = 1; i < dn.length; i++) {
			if (dn[i] < dn.length && dn[i] > 0) {
				if (dn[dn[i]] == i && dn[i] != i) {
					System.out.println(i + " , " + dn[i]);
					sum += i;
				}
			}
		}
		System.out.println(sum);
	}

	public static int dn(int n) {
		int sum = 0;
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				sum += i;
				sum += n / i;
			}
		}
		if (Math.sqrt(n) == (int) Math.sqrt(n)) {
			sum += (int) Math.sqrt(n);
		}
		sum -= n;
		return sum;
	}

}