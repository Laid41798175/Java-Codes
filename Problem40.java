package projectEuler;

public class Problem40 {

	public static void main(String[] args) {
		int count = 0;
		int mtp = 1;
		for (int i = 1; count <= 1000000; i++) {
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				count++;
				switch (count) {
				case 1:
				case 10:
				case 100:
				case 1000:
				case 10000:
				case 100000:
				case 1000000:
					mtp *= Integer.valueOf(str.substring(j, j + 1));
					break;
				default:
				}
			}
		}
		System.out.println(mtp);
	}

}
