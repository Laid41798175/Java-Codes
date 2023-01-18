package projectEuler;

public class Problem38 {

	public static void main(String[] args) {
		int maxi = 0;
		int max = 0;
		for (int i = 91; i <= 100000; i++) {
			int temp = pandigital(i);
			if (temp > max) {
				maxi = i;
				max = temp;
			}
		}
		
		System.out.println(max + " by " + maxi);

	}

	public static int pandigital(int n) {
		String ret = "";
		int num = 0;
		int digit = 0;

		boolean[] arr = new boolean[10];
		arr[0] = true;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = false;
		}

		while (true) {
			num += n;
			String str = Integer.toString(num);
			int length = str.length();
			digit += length;

			for (int i = 0; i < length; i++) {
				if (arr[Integer.valueOf(str.substring(i, i + 1))]) {
					return -1;
				} else {
					arr[Integer.valueOf(str.substring(i, i + 1))] = true;
				}
			}

			ret += str;

			if (digit == 9) {
				break;
			}
		}

		return Integer.valueOf(ret);
	}

}
