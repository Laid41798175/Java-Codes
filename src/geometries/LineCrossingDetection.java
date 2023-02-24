package geometries;

import java.io.*;
import java.util.*;

public class LineCrossingDetection {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringTokenizer stk;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		Line l1 = new Line(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
				Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		str = br.readLine();
		stk = new StringTokenizer(str);
		Line l2 = new Line(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
				Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		
		System.out.println(l1.isCrossing(l2));
	}
	
	static class Line {	
		long x1;
		long y1;
		long x2;
		long y2;

		Line(long a, long b, long c, long d) {
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}

		public boolean isCrossing(Line o) {		
			// a * d - b * c
			long i0 = (o.x1 - x1) * (o.y2 - y1) - (o.y1 - y1) * (o.x2 - x1);
			long i1 = (o.x1 - x2) * (o.y2 - y2) - (o.y1 - y2) * (o.x2 - x2);
			long i2 = (o.x1 - x1) * (o.y1 - y2) - (o.y1 - y1) * (o.x1 - x2);
			long i3 = (o.x2 - x1) * (o.y2 - y2) - (o.y2 - y1) * (o.x2 - x2);

			if (i0 == 0 && i1 == 0 && i2 == 0 && i3 == 0) {
				if (isOverlapped(x1, x2, o.x1, o.x2) && isOverlapped(y1, y2, o.y1, o.y2)) {
					return true;
				} else {
					return false;
				}
			}
			if (i0 * i1 <= 0 && i2 * i3 <= 0) {
				return true;
			} else {
				return false;
			}
		}

		static boolean isOverlapped(long x0, long x1, long x2, long x3) {
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

}
