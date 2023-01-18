package projectEuler;

public class Problem41 {

	static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		max = 0;
		
		int n = 7; // no 8, 9

		int[] numbers = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
			visited[i] = false;
		}

		count(numbers, visited, 0, 0, n);
	}

	public static void count(int[] arr, boolean[] visit, int digit, int num, int n) {

		if (digit >= n) { // Permutation completed
			if (isPrime(num)) {
				if (num > max) {
					max = num;
					System.out.println(max);
				}
			}
		}
		for (int i = 1; i < n + 1; i++) {
			if (!visit[i]) {
				boolean[] temp = new boolean[n + 1];
				for (int j = 0; j < n + 1; j++) {
					temp[j] = visit[j]; // need to deep copy
				}
				temp[i] = true;
				count(arr, temp, digit + 1, num * 10 + i, n);
			}
		}
	}

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
