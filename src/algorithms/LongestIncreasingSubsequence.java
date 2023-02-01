package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncreasingSubsequence {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;

	static String str;
	static String[] spl;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		n = Integer.parseInt(str);
		int[] arr = new int[n + 1];

		str = br.readLine();
		spl = str.split(" ");
		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(spl[i]);
		}

		int[] d = lis(arr);
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int val = d[i];
			if (val > ans) ans = val;
		}
		
		System.out.println(ans);
	}

	static int[] lis (int[] arr) {
		int[] d = new int[n + 1];
		int[] a = new int[n + 1];
		d[0] = 0;
		a[0] = 0;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int j = 1; j <= max; j++) {
				if (arr[i] <= a[j]) { // May use binary search
					flag = false;
					d[i] = j;
					a[j] = arr[i];
					break;
				}
			}
			if (flag) {
				max++;
				a[max] = arr[i];
				d[i] = max;
			}
		}
		return d;
	}	
}