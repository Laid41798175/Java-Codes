package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class KMP {

	static long start;
	static long end;

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		String str = br.readLine();
		String tgt = br.readLine();

		Vector<Integer> vec;

		start = System.currentTimeMillis();
		vec = find(str, tgt);
		end = System.currentTimeMillis();
		System.out.println(vec.toString());
		printTime();
	}

	static Vector<Integer> find(String str, String tgt) {
		Vector<Integer> ret = new Vector<>();
		int[] pi = pi(tgt);

		int n = str.length();
		int m = tgt.length();
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j > 0 && str.charAt(i) != tgt.charAt(j)) {
				j = pi[j - 1];
			}
			if (str.charAt(i) == tgt.charAt(j)) {
				if (j == m - 1) {
					ret.add(i - m + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return ret;
	}

	static int[] pi(String tgt) {
		int m = tgt.length();
		int[] pi = new int[m];
		int j = 0;
		for (int i = 1; i < m; i++) {
			while (j > 0 && tgt.charAt(i) != tgt.charAt(j)) {
				j = pi[j - 1];
			}
			if (tgt.charAt(i) == tgt.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static void printTime() {
		System.out.println((end - start) + "ms");
	}

}
