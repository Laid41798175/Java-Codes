package projectEuler;

public class Problem43 {

	public static long sum = 0;

	public static void main(String[] args) {
		sum = 0;

		int[] numbers = new int[10];
		boolean[] visited = new boolean[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
			visited[i] = false;
		}

		count(numbers, visited, 0, "");

		System.out.println(sum);
	}

	public static void count(int[] arr, boolean[] visit, int digit, String num) {

		if (digit >= 10) { // Permutation completed
			if (isSubstring(num)) {
				System.out.println(num);
				sum += Long.valueOf(num);
			}

		}

		for (int i = 0; i < 10; i++) {
			if (!visit[i]) {
				boolean[] temp = new boolean[10];
				for (int j = 0; j < 10; j++) {
					temp[j] = visit[j]; // need to deep copy
				}
				temp[i] = true;
				count(arr, temp, digit + 1, num.concat(String.valueOf(i)));
			}
		}
	}

	public static boolean isSubstring(String num) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17 };
		
		for (int i = 1; i < 8; i++) {
			String substr = num.substring(i, i + 3);
			int subnum = Integer.valueOf(substr);
			if (subnum % prime[i - 1] != 0) {
				return false;
			}
		}
		return true;
	}
}
