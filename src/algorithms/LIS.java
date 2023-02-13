package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static int n;

	static String str;
	static String[] spl;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		n = Integer.parseInt(str);
		int[] arr = new int[n + 1];

		str = br.readLine();
		stk = new StringTokenizer(str);
		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(stk.nextToken());
		}

		lis(arr);
	}

	static int max = 0;
	static int maxIndex = -1;

	static void lis(int[] arr) {
		int[] prev = new int[n + 1];
		int[] aValue = new int[n + 1];
		int[] aIndex = new int[n + 1];

		max = 0;
		for (int i = 1; i <= n; i++) {
			int index = binarySearch(aValue, max, arr[i]);

			aValue[index] = arr[i];
			prev[i] = aIndex[index - 1];
			aIndex[index] = i;

			if (max < index) {
				max = index;
				maxIndex = i;
			}
		}

		sb.append(max + "\n");
		int[] ans = new int[max];
		int idx = 0;
		while (maxIndex != 0) {
			ans[idx++] = arr[maxIndex];
			maxIndex = prev[maxIndex];
		}
		for (int i = max - 1; i >= 0; i--) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}

	static int binarySearch(int[] a, int aMax, int value) { // a is sorted
		if (aMax == 0) {
			return 1;
		}

		int start = 1;
		int end = aMax; // inclusive
		while (start < end) {
			int half = (start + end) / 2;
			if (a[half] == value) {
				return half;
			} else if (a[half] < value) {
				start = half + 1;
			} else { // if (value < a[half]) {
				end = half;
			}
		}

		if (end == aMax && a[aMax] < value) {
			return aMax + 1;
		}

		return start;
	}
}