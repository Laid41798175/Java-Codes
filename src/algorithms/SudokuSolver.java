package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SudokuSolver {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;
	static int m;

	static String str;
	static String[] spl;

	static int[][] zeros = new int[81][2];
	static int count = 0;

	public static void main(String[] args) throws IOException {
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			str = br.readLine();
			spl = str.split(" ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(spl[j]);
				if (arr[i][j] == 0) {
					zeros[count][0] = i;
					zeros[count][1] = j;
					count++;
				}
			}
		}

		solveSudoku(arr);
		
		System.out.print(sb);
	}
	
	public static void solveSudoku(int[][] arr) {
		solve(arr, 0);
	}
	
	public static void solve(int[][] arr, int fill) {
		if (fill == count) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}

		int currX = zeros[fill][0];
		int currY = zeros[fill][1];

		for (int i = 1; i <= 9; i++) {
			arr[currX][currY] = i;
			if (checkColumn(currX, arr) && checkRow(currY, arr) && checkSquare(currX, currY, arr)) {
				solve(arr, fill + 1);
			}
			arr[currX][currY] = 0;
		}
	}
	
	public static boolean checkColumn(int x, int[][] arr) {
		int[] check = new int[10];
		for (int i = 0; i < 9; i++) {
			check[arr[x][i]]++;
		}
		for (int i = 1; i <= 9; i++) {
			if (check[i] > 1)
				return false;
		}
		return true;
	}

	public static boolean checkRow(int y, int[][] arr) {
		int[] check = new int[10];
		for (int i = 0; i < 9; i++) {
			check[arr[i][y]]++;
		}
		for (int i = 1; i <= 9; i++) {
			if (check[i] > 1)
				return false;
		}
		return true;
	}

	public static boolean checkSquare(int x, int y, int[][] arr) {
		int[] check = new int[10];
		for (int i = x - x % 3; i < x - x % 3 + 3; i++) {
			for (int j = y - y % 3; j < y - y % 3 + 3; j++) {
				check[arr[i][j]]++;
			}
		}
		for (int i = 1; i <= 9; i++) {
			if (check[i] > 1)
				return false;
		}
		return true;
	}

}