package projectEuler;

public class Problem36 {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i <= 1000000; i++) {
			String dec = Integer.toString(i);
			if (isPalindrome(dec)) {
				String bin = Integer.toBinaryString(i);
				if (isPalindrome(bin)) {
					System.out.println(dec + " / " + bin + "(2)");
					sum += i;
				}
			}
		}
		System.out.println(sum);

	}

	public static boolean isPalindrome(String n) {
		char[] chars = n.toCharArray();
		for (int i = 0; i <= chars.length / 2 - 1; i++) {
			if (chars[i] != chars[chars.length - i - 1]) {
				return false;
			}
		}
		return true;
	}

}
