package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TSP {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;

	static int[][] arr;
	static int[][] D;

	static String str;
	static String[] spl;

	final static int INF = 100_000_000;
	static long sum = 0;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		n = Integer.parseInt(str);
		arr = new int[n][n];
		D = new int[n][1 << (n - 1)];

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			spl = str.split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(spl[j]);
				if (arr[i][j] == 0) {
					arr[i][j] = INF;
				}
			}
		}

		System.out.println(cost(0, (1 << (n - 1)) - 1));
	}

	public static int cost(int start, int bitmask) {
		if (D[start][bitmask] != 0) return D[start][bitmask];
		
		int[] set = toSet(bitmask);

		if (set.length == 0) {
			return D[start][bitmask] = arr[start][0];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < set.length; i++) {
			int tmp = bitmask - (1 << (set[i] - 1));
			int cost = cost(set[i], tmp) + arr[start][set[i]];
			if (cost > INF)
				cost = INF;
			if (cost < min) {
				min = cost;
			}
		}
		return D[start][bitmask] = min;
	}

	public static int[] toSet(int bitmask) {
		ArrayList<Integer> power = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			int tgt = 1 << (i - 1);
			if ((bitmask & tgt) == tgt) {
				power.add(i);
			}
		}

		int[] ret = new int[power.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = power.get(i);
		}
		return ret;
	}

}