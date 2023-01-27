package primeNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExComb {
	
	static long start;
	static long end;

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
		
		start = System.currentTimeMillis();
		System.out.println(nCr(n, k));
		end = System.currentTimeMillis();
		printTime();
		
		str = br.readLine();
		spl = str.split(" ");
		n = Integer.parseInt(spl[0]);
		k = Integer.parseInt(spl[1]);
		
		start = System.currentTimeMillis();
		System.out.println(nCr2(n, k));
		end = System.currentTimeMillis();
		printTime();
	}
	
	public static int nCr(int n, int r) {
		if (r == 0 || r == n) return values[n][r] = 1;
		if (r == 1 || r == n - 1) return values[n][r] = n;
		
		if (isChecked[n][r]) return values[n][r];
		isChecked[n][r] = true;
		return values[n][r] = (nCr(n-1, r-1) + nCr(n-1, r)) % 10007;
	}
	
	public static int nCr2(int n, int r) {
		if (r == 0 || r == n) return 1;
		if (r == 1 || r == n - 1) return n;
		
		// if (isChecked[n][r]) return values[n][r];
		// isChecked[n][r] = true;
		return (nCr2(n-1, r-1) + nCr2(n-1, r)) % 10007;
	}
	
	static void printTime() {
		System.out.println((end - start) + "ms");
	}
}
