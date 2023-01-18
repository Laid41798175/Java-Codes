package projectEuler;

public class Problem10 {

	public static void main(String[] args) {
		long sum = 5; // 2와 3은 미리 카운트
		for (int i = 4; i <= 2000000; i++) {
			sum += isPrime(i);
		}
		System.out.println(sum);
	}

	public static int isPrime(int n) { // 소수 측정 메소드
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i != 0)
				continue;
			else
				return 0;
		}
		return n;
	}

}