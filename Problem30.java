package projectEuler;

public class Problem30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int START = 10;
		final int END = 500000;
		String str;
		int tempSum;

		int sum = 0;
		for (int i = START; i < END; i++) {
			str = Integer.toString(i);
			tempSum = 0;

			for (int j = 0; j < str.length(); j++) {
				tempSum += fifthPowers(Character.getNumericValue(str.charAt(j)));
			}
			if (tempSum == i) {
				sum += i;
				System.out.println(i);
			}
		}

		System.out.println(sum);
	}

	private static int fifthPowers(int aNumber) {
		int ret = 1;
		for (int i = 0; i < 5; i++) {
			ret *= aNumber;
		}
		return ret;
	}

}
