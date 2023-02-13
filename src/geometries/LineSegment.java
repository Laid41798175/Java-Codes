package geometries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LineSegment {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static int n;
	static int m;

	static long[] x = new long[4];
	static long[] y = new long[4];

	static String str;
	static String[] spl;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		x[0] = Long.parseLong(stk.nextToken());
		y[0] = Long.parseLong(stk.nextToken());
		x[1] = Long.parseLong(stk.nextToken());
		y[1] = Long.parseLong(stk.nextToken());

		str = br.readLine();
		stk = new StringTokenizer(str);
		x[2] = Long.parseLong(stk.nextToken());
		y[2] = Long.parseLong(stk.nextToken());
		x[3] = Long.parseLong(stk.nextToken());
		y[3] = Long.parseLong(stk.nextToken());

		Vector v02 = new Vector(0, 2);
		Vector v03 = new Vector(0, 3);
		Vector v12 = new Vector(1, 2);
		Vector v13 = new Vector(1, 3);
		Vector v20 = new Vector(2, 0);
		Vector v21 = new Vector(2, 1);
		Vector v30 = new Vector(3, 0);
		Vector v31 = new Vector(3, 1);

		int i0 = v02.OuterProduct(v03);
		int i1 = v12.OuterProduct(v13);
		int i2 = v20.OuterProduct(v21);
		int i3 = v30.OuterProduct(v31);

		if (i0 == 0 && i1 == 0 && i2 == 0 && i3 == 0) {
			if (isCrossing(x[0], x[1], x[2], x[3]) && isCrossing(y[0], y[1], y[2], y[3])) {
				System.out.println(1);
				Arrays.sort(x);
				Arrays.sort(y);
				if (x[1] == x[2] && y[1] == y[2]) {
					System.out.println(x[1] + " " + y[1]);
				}
			} else {
				System.out.println(0);
			}
			return;
		}

		if (i0 * i1 <= 0 && i2 * i3 <= 0) {
			System.out.println(1);
			if (x[0] == x[1] && x[2] == x[3]) {
				// This is not possible;
			} else if (x[0] == x[1]) { // x = x[0]
				double crossY = (y[3] - y[2]) * (x[0] - x[2]) / ((double) (x[3] - x[2])) + y[2];
				System.out.println(x[0] + " " + crossY);
			} else if (x[2] == x[3]) { // x = x[2];
				double crossY = (y[1] - y[0]) * (x[2] - x[0]) / ((double) (x[1] - x[0])) + y[0];
				System.out.println(x[2] + " " + crossY);
			} else {
				double m0 = (y[1] - y[0]) / (double) (x[1] - x[0]);
				double m2 = (y[3] - y[2]) / (double) (x[3] - x[2]);
				if (m0 == m2) {
					Arrays.sort(x);
					Arrays.sort(y);
					System.out.println(x[1] + " " + y[1]);
				} else {
					double crossX = (m2 * x[2] - m0 * x[0] + y[0] - y[2]) / (m2 - m0);
					double crossY = m0 * crossX - m0 * x[0] + y[0];
					System.out.println(crossX + " " + crossY);
				}
			}
		} else {
			System.out.println(0);
		}
	}

	static boolean isCrossing(long x0, long x1, long x2, long x3) {
		if (x0 > x1) {
			long tmp = x0;
			x0 = x1;
			x1 = tmp;
		}
		if (x2 > x3) {
			long tmp = x2;
			x2 = x3;
			x3 = tmp;
		}
		return (x2 <= x0 && x0 <= x3) || (x2 <= x1 && x1 <= x3) || (x0 <= x2 && x2 <= x1) || (x0 <= x3 && x3 <= x1);
	}
}

class Vector {
	long x;
	long y;

	Vector(int p0, int p1) {
		x = LineSegment.x[p1] - LineSegment.x[p0];
		y = LineSegment.y[p1] - LineSegment.y[p0];
	}

	int OuterProduct(Vector v) {
		long val = x * v.y - y * v.x;
		if (val > 0) {
			return 1;
		} else if (val < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}