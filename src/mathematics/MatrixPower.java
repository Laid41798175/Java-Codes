package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MatrixPower {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static String[] spl;

	static int n;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		spl = str.split(" ");
		n = Matrix.n = Integer.parseInt(spl[0]);
		BigInteger num = new BigInteger(spl[1]);

		String bnr = "";
		while (num.compareTo(BigInteger.ONE) != 0) {
			bnr += num.testBit(0) ? "1" : "0";
			num = num.shiftRight(1);
		}
		bnr += "1";

		Matrix A = new Matrix();
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			spl = str.split(" ");
			for (int j = 0; j < n; j++) {
				A.mat[i][j] = Integer.parseInt(spl[j]);
			}
		}

		Matrix pow = power(A, bnr);		
		pow.print();
	}
	
	public static Matrix power(Matrix A, String bnrPower) {
		Matrix idt = Matrix.identity();
		Matrix[] As = new Matrix[bnrPower.length()];
		for (int i = 0; i < bnrPower.length(); i++) {
			if (i == 0) {
				As[0] = A;
			} else {
				As[i] = As[i - 1].multiply(As[i - 1]);
			}

			if (bnrPower.charAt(i) == '1') {
				idt = idt.multiply(As[i]);
			}
		}
		return idt;
	}
}

class Matrix {

	final static int X = 1_000;
	int[][] mat;
	public static int n;

	Matrix() {
		mat = new int[n][n];
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static Matrix identity() {
		Matrix idt = new Matrix();
		for (int i = 0; i < n; i++) {
			idt.mat[i][i] = 1;
		}
		return idt;
	}

	public Matrix multiply(Matrix m) {
		Matrix ret = new Matrix();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < n; k++) {
					sum += mat[i][k] * m.mat[k][j];
				}
				ret.mat[i][j] = sum % X;
			}
		}
		return ret;
	}
}