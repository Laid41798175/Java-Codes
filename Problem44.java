package projectEuler;

public class Problem44 {

	static int[] arr = new int[10000];

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * (3 * i + 2) / 2;
		}

		System.out.println(isPen(144));
		System.out.println(isPen(145));
		System.out.println(isPen(146));

		int min = 1000000000;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				int diff = arr[j] - arr[i];

				if (isPen(sum) && isPen(diff)) {
					if (diff < min) {
						min = diff;
					}
				}

			}
		}
		System.out.println(min);
	}

	public static boolean isPen(int n) {
		for (int i = 0; i < arr.length; i++) {
			if (n == arr[i]) {
				return true;
			} else if (n < arr[i]) {
				return false;
			}
		}
		return false;
	}

}
