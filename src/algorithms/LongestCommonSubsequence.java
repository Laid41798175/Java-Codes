package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;
	static int m;

	static String str;
	static String[] spl;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		System.out.println(lcs(str1, str2));
	}

	static int lcs(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] arr = new int[len1 + 1][len2 + 1];

		int max = -1;
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = arr[i - 1][j] > arr[i][j - 1] ? arr[i - 1][j] : arr[i][j - 1];
				}

				if (max < arr[i][j])
					max = arr[i][j];
			}
		}

		return max;
	}

}