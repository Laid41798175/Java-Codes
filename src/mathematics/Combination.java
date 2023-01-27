package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static String[] spl;
	
	static int[][] values;
	static boolean[][] isChecked; // can trust values
	
	public static void main(String[] args) throws IOException {
		str = br.readLine();
		spl = str.split(" ");
		int n = Integer.parseInt(spl[0]);
		int k = Integer.parseInt(spl[1]);
		if (k > n / 2) k = n - k;
		
		values = new int[n + 1][k + 1];
		isChecked = new boolean[n + 1][k + 1];
		
		System.out.println(nCr(n, k));
	}
	
	public static int nCr(int n, int r) {
		if (r == 0 || r == n) return values[n][r] = 1;
		if (r == 1 || r == n - 1) return values[n][r] = n;
		
		if (isChecked[n][r]) return values[n][r];
		isChecked[n][r] = true;
		return values[n][r] = nCr(n-1, r-1) + nCr(n-1, r);
	}

}
