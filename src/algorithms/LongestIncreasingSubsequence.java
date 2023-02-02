package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

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
		
		System.out.println(max);
	}
	
	static int max = 0;
	
	static int[] lis (int[] arr) {
		int[] d = new int[n + 1];
		int[] a = new int[n + 1];
		
		d[1] = 1;
		a[1] = arr[1];
		
		max = 1;
		for (int i = 2; i <= n; i++) {			
			int index = binarySearch(a, max, arr[i]);
			d[i] = index;
			a[index] = arr[i];
			
			if (max < index) {
				max = index;
			}
		}
			
		return d;
	}
	
	static int binarySearch(int[] a, int aMax, int value) { // a is sorted
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