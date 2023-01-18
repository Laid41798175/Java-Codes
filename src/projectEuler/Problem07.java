package projectEuler;

public class Problem07 {

	public static void main(String[] args) {
		int count = 2; // 2와 3은 미리 계산 한다.
		for (int n = 4; n < 1000000000; n++) {
			count += Prime(n);
			if (count == 10001) {
				System.out.println(n);
				System.exit(0);
			}
		}
	}

	public static int Prime(int n) { // 소수 측정 메소드
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i != 0)
				continue;
			else
				return 0;
		}
		return 1;
	}

}