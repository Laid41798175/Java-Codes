package projectEuler;

public class Problem31 {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
		System.out.println(count(coins, 7, 200));
	}

	public static int count(int[] array, int available, int goal) {
		if (available < 0) {
			return 0;
		}
		
		if (goal == 0) {
			return 1;
		} else if (goal < 0) {
			return 0;
		}

		return count(array, available - 1, goal) + count(array, available, goal - array[available]);
	}

}
