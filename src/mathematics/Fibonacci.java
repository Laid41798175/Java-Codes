package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Fibonacci {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static String[] spl;

	static int n;
	static int m;

	static int max;

	public static void main(String[] args) throws IOException {
		str = br.readLine();		
		BigInteger num = new BigInteger(str);
		String bnr = "";
		while (num.compareTo(BigInteger.ONE) != 0) {
			bnr += num.remainder(BigInteger.TWO).toString();
			num = num.divide(BigInteger.TWO);
		}
		bnr += "1";
		
		FibMatrix idt = FibMatrix.identity();
		FibMatrix[] Ms = new FibMatrix[bnr.length() + 1];
		FibMatrix M = new FibMatrix(1, 1, 1, 0);
		for (int i = 0; i < bnr.length(); i++) {
			if (i == 0) {
				Ms[0] = M;
			} else {
				Ms[i] = Ms[i - 1].multiply(Ms[i - 1]);
			}
			
			if (bnr.charAt(i) == '1') {				
				idt = idt.multiply(Ms[i]);
			}
		}

		System.out.println(idt.mat[0][1]);
	}
}

class FibMatrix {

	final static long X = 1_000_000_007;
	long[][] mat = new long[2][2];

	FibMatrix(long a00, long a01, long a10, long a11) {
		mat[0][0] = a00;
		mat[0][1] = a01;
		mat[1][0] = a10;
		mat[1][1] = a11;
	}

	FibMatrix() {
	}
	
	public void print() {
		System.out.println(mat[0][0] + " " + mat[0][1]);
		System.out.println(mat[1][0] + " " + mat[1][1]);
	}

	public static FibMatrix identity() {
		return new FibMatrix(1, 0, 0, 1);
	}

	public FibMatrix multiply(FibMatrix m) {
		FibMatrix ret = new FibMatrix();
		ret.mat[0][0] = ((mat[0][0] * m.mat[0][0]) % X + (mat[0][1] * m.mat[1][0]) % X) % X;
		ret.mat[0][1] = ((mat[0][0] * m.mat[0][1]) % X + (mat[0][1] * m.mat[1][1]) % X) % X;
		ret.mat[1][0] = ((mat[1][0] * m.mat[0][0]) % X + (mat[1][1] * m.mat[1][0]) % X) % X;
		ret.mat[1][1] = ((mat[1][0] * m.mat[0][1]) % X + (mat[1][1] * m.mat[1][1]) % X) % X;
		return ret;
	}
}