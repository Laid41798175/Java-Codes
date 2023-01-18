package projectEuler;

public class Problem17 {

	public static void main(String[] args) {
		int letter[] = new int[1001];
		letter[0] = 0; // doesn't count
		letter[1] = 3; // one
		letter[2] = 3; // two
		letter[3] = 5; // three
		letter[4] = 4; // four
		letter[5] = 4; // five
		letter[6] = 3; // six
		letter[7] = 5; // seven
		letter[8] = 5; // eight
		letter[9] = 4; // nine
		letter[10] = 3; // ten
		letter[11] = 6; // eleven
		letter[12] = 6; // twelve
		letter[13] = 8; // thirteen
		letter[14] = 8; // fourteen
		letter[15] = 7; // fifteen
		letter[16] = 7; // sixteen
		letter[17] = 9; // seventeen
		letter[18] = 8; // eighteen
		letter[19] = 8; // nineteen
		letter[20] = 6; // twenty
		letter[30] = 6; // thirty
		letter[40] = 5; // forty
		letter[50] = 5; // fifty
		letter[60] = 5; // sixty
		letter[70] = 7; // seventy
		letter[80] = 6; // eighty
		letter[90] = 6; // ninety
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				letter[i * 10 + j] = letter[i * 10] + letter[j];
			}
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (j == 0) {
					letter[i * 100 + j] = letter[i] + 7; // xxx hundred
				} else {
					letter[i * 100 + j] = letter[i] + 7 + 3 + letter[j]; 
			          // xxx hundred and xxx	
                }
			}
		}
		letter[1000] = 11;
		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			count += letter[i];
		}
		System.out.println(count);
	}
	
}