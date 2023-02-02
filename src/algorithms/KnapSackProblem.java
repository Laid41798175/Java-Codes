package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnapSackProblem {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String str;
	static String[] spl;

	static int n;
	static int k;

	static int[] w;
	static int[] v;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		spl = str.split(" ");
		n = Integer.parseInt(spl[0]);
		k = Integer.parseInt(spl[1]);

		w = new int[n];
		v = new int[n];

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			spl = str.split(" ");
			w[i] = Integer.parseInt(spl[0]);
			v[i] = Integer.parseInt(spl[1]);
		}

		int maxValue = knapSack(w, v);
		
		System.out.println(maxValue);
	}

	public static int knapSack(int[] w, int[] v) {
		int[][] arr = new int[n][k + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i == 0) {
					if (j < w[i])
						arr[i][j] = 0;
					else
						arr[i][j] = v[i];
					continue;
				}

				if (j < w[i]) {
					arr[i][j] = arr[i - 1][j];
				} else { // if (w[i] <= j)
					if (arr[i - 1][j] < arr[i - 1][j - w[i]] + v[i])
						arr[i][j] = arr[i - 1][j - w[i]] + v[i];
					else
						arr[i][j] = arr[i - 1][j];
				}
			}
		}

		return arr[n - 1][k];
	}
}
