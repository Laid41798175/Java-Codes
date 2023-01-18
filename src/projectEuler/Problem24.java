package projectEuler;

public class Problem24 {

	public static void main(String[] args) {
		int pm[] = new int[10];
		int check = 999999; // 1000000 번째 전 순열들을 세는 중
		for (int i = 0; i < pm.length; i++) {
			pm[i] = (int) (check / facto(9 - i));
			check %= facto(9 - i);
		}
		for (int i = 1; i < pm.length; i++) { // 이 구문이 뭘 의미할까?
			int count = 0;
			for (int j = 0; j <= pm[i] + count; j++) {
				for (int k = 0; k < i; k++) {
					if (pm[k] == j) {
						count++;
						continue;
					}
				}
			}
			pm[i] += count;
		}
		for (int i = 0; i < pm.length; i++) {
			System.out.print(pm[i]);
		}
	}

	public static int facto(int n) {
		int facto = 1;
		for (int i = 1; i <= n; i++) {
			facto *= i;
		}
		return facto;
	}

}