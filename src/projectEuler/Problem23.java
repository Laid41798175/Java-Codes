package projectEuler;

public class Problem23 {

	public static void main(String[] args) {
		int check[] = new int[28124];
		for (int i = 0; i < check.length; i++) {
			check[i] = i;
		}
		int count = 0;
		for (int i = 1; i < check.length; i++) {
			if (abundant(i)) {
				count++;
			} 
		}
		int abunnum[] = new int[count];
		int arraynum = 0;
		for (int i = 1; i < check.length; i++) {
			if (abundant(i)) {
				abunnum[arraynum] = i;
				arraynum++; 
			}
		}
		System.out.println(abunnum[1]);
		for (int i = 0; i < abunnum.length; i++) {
			for (int j = 0; j < abunnum.length; j++) {
				int n = abunnum[i] + abunnum[j];
				if (n < check.length) {
					check[n] = 0;
				}
			}
		}
		int sum = 0;
		for (int i = 1; i < check.length; i++) {
			sum += check[i];
		}
		System.out.println(sum);

	}

	public static boolean abundant(int n) {
		int sum = 0;
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				sum += i;
				sum += n / i;
			}
		}
		if (Math.sqrt(n) == (int) Math.sqrt(n)) {
			sum += Math.sqrt(n);
		}
		sum -= n;
		if (sum > n) {
			return true;
		} else {
			return false;
		}
	}

}