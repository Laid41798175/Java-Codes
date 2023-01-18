package projectEuler;

import java.util.*;

public class Problem32 {

	static List<Integer> elist = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int[] numbers = new int[10];
		boolean[] visited = new boolean[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
			visited[i] = false;
		}

		System.out.println(count(numbers, visited, 0, 0));
	}

	public static int count(int[] arr, boolean[] visit, int digit, int num) {

		if (digit >= 9) { // Permutation completed
			return check(num);
		}

		int sum = 0;

		for (int i = 1; i < 10; i++) {
			if (!visit[i]) {
				boolean[] temp = new boolean[10];
				for (int j = 0; j < 10; j++) {
					temp[j] = visit[j]; // need to deep copy
				}
				temp[i] = true;
				sum += count(arr, temp, digit + 1, num * 10 + i);
			}
		}

		return sum;
	}

	public static int check(int num) {
		String str = String.valueOf(num); // 123456789
		int a = Integer.valueOf(str.substring(0, 1)); // 1
		int b = Integer.valueOf(str.substring(1, 5)); // 2345
		int c = Integer.valueOf(str.substring(0, 2)); // 12
		int d = Integer.valueOf(str.substring(2, 5)); // 345
		int e = Integer.valueOf(str.substring(5, 9)); // 6789

		if (a * b == e) {
			System.out.println(a + " * " + b + " = " + e);
			for (int es : elist) { // check e once
				if (es == e) {
					System.out.println("but " + e + " is on list already.");
					return 0;
				}
			}
			elist.add(e);
			return e;
		} else if (c * d == e) {
			System.out.println(c + " * " + d + " = " + e);
			for (int es : elist) { // check e once
				if (es == e) {
					System.out.println("but " + e + " is on list already.");
					return 0;
				}
			}
			elist.add(e);
			return e;
		} else {
			return 0;
		}
	}

}
