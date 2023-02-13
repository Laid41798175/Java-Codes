package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCS {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static int T;
	static int n;
	static int m;

	static String str;

	public static void main(String[] args) throws IOException {
		String str1 = br.readLine();
		String str2 = br.readLine();

		String ans = lcs(str1, str2);
		System.out.println(ans.length());
		System.out.println(ans);
	}
	
	static String lcs(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] arr = new int[len1 + 1][len2 + 1];
		int[][] come = new int[len1 + 1][len2 + 1];

		int max = 0;
		int maxX = 0;
		int maxY = 0;
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
					come[i][j] = 2;
					if (max < arr[i][j]) {
						maxX = i;
						maxY = j;
						max++;
					}
				} else {
					if (arr[i - 1][j] > arr[i][j - 1]) {
						arr[i][j] = arr[i - 1][j];
						come[i][j] = 0;
					} else {
						arr[i][j] = arr[i][j - 1];
						come[i][j] = 1;
					}
				}
			}
		}
		
		StringBuilder str = new StringBuilder();
		
		while (max > 0) {
			if (come[maxX][maxY] == 2) {
				str.insert(0, str1.charAt(maxX - 1));
				max--;				
				maxX--;
				maxY--;
			} else if (come[maxX][maxY] == 1) {
				maxY--;
			} else {
				maxX--;
			}
		}
		return str.toString();
	}
}