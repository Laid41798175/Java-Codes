package projectEuler;

public class Problem19 {

	public static void main(String[] args) {
		int NLY[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
		int LY[] = { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 }; 
		boolean Sunday[] = new boolean[(366 + 365 * 3) * 25];
		boolean firstday[] = new boolean[(366 + 365 * 3) * 25];
		for (int i = 0; i < Sunday.length; i++) {
			if (i % 7 == 5) {
				Sunday[i] = true;
			}
		}
		for (int i = 0; i < firstday.length; i++) {
			int rotate = i % 366 + 365 * 3;
			if (rotate < 365 * 3) {
				rotate %= 365;
				for (int j = 0; j < NLY.length; j++) {
					if (rotate == NLY[j]) {
						firstday[i] = true;
					}
				}
			} else {
				rotate -= 365 * 3;
				for (int j = 0; j < LY.length; j++) {
					if (rotate == LY[j]) {
						firstday[i] = true;
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < Sunday.length; i++) {
			if (Sunday[i] && firstday[i] == true) {
				count++;
			}
		}
		System.out.println(count);
	}

}