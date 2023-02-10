package dataStructure;

public class LowerBound {

	static int[] arr;
	
	public static void main(String[] args) {
		arr = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 7, 7, 8 };
		for (int i = 0; i < 9; i++) {
			System.out.println(i + ": " + lowerBound(i));
		}
	}

	public static int lowerBound(int tgt) {
		int start = 0;
		int end = arr.length;
		int half;
		while (end - start > 0) {
			half = (start + end) / 2;
			if (arr[half] < tgt) {
				start = half + 1;
			} else {
				end = half;
			}
		}
		return end;
	}

}
