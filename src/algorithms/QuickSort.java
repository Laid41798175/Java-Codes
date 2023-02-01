package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

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

		arr = sort(arr);
		print(arr);
	}

	static int[] sort(int[] arr) {
		if (arr.length <= 1)
			return arr;

		int pivot = arr[0];
		int left = 0;
		int right = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > pivot) {
				right++;
			} else {
				left++;
			}
		}
		int[] lefts = new int[left];
		int[] rights = new int[right];
		left = 0;
		right = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > pivot) {
				rights[right] = arr[i];
				right++;
			} else {
				lefts[left] = arr[i];
				left++;
			}
		}

		lefts = sort(lefts);
		rights = sort(rights);
		return concat(lefts, pivot, rights);
	}

	static int[] concat(int[] left, int pivot, int[] right) {
		int[] arr = new int[left.length + 1 + right.length];
		int i = 0;
		for (; i < left.length; i++) {
			arr[i] = left[i];
		}
		arr[i] = pivot;
		i++;
		for (int j = 0; j < right.length; j++) {
			arr[i] = right[j];
			i++;
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
