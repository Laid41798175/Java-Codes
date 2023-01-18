package projectEuler;

public class Problem14 {

	public static void main(String[] args) {
		int bigChain = 0;
        int big = 0;
		for (int i = 2; i <= 1000000; i++) {
			int count = 0;
			long n = i; // 우박수를 계산하는 과정에서, n이 int의 범위를 초과.
			while (n != 1) {
				if (n % 2 == 0) {
					n /= 2;
				} else {
					n = 3 * n + 1;
				}
				count++;
			}
			if (count >= bigChain) {
				big = i;
				bigChain = count;
			}
		}
        System.out.println(big);
	}

}