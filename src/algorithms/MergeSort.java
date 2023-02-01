package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);

		int[] arr = new int[n];
		str = br.readLine();
		String[] spl = str.split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(spl[i]);
		}

		sort(arr, 0, arr.length);
		print(arr);
	}
	
	static void sort(int[] arr, int start, int end) {
		if (start >= end - 1)
			return;
		int half = (end + start) / 2;
		sort(arr, start, half);
		sort(arr, half, end);
		merge(arr, start, half, end);
	}
	
	static int[] merge(int[] arr, int start, int half, int end) {
		int[] ret = new int [end - start];
		int left = 0; int right = 0;
		int index = 0;
		while (start + left < half && half + right < end) {
			if (arr[start + left] < arr[half + right]) {
				ret[index] = arr[start + left];
				left++;
			} else {
				ret[index] = arr[half + right];
				right++;
			}
			index++;
		}
		
		while (start + left < half) {
			ret[index] = arr[start + left];
			left++;
			index++;
		}
		while (half + right < end) {
			ret[index] = arr[half + right];
			right++;
			index++;
		}		
		
		for (int i = 0; i < ret.length; i++) {
			arr[start + i] = ret[i];
		}
		return arr;
	}
	
	static void print (int[] num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			sb.append(num[i] +" ");
		}
		System.out.println(sb);
	}
}
