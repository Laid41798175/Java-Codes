package projectEuler;

import java.util.*;

public class Problem45 {

	public static void main(String[] args) {

		int MAX = 2000000000;

		ArrayList<Long> tri = new ArrayList<>();
		ArrayList<Long> pen = new ArrayList<>();
		ArrayList<Long> hex = new ArrayList<>();

		for (long n = 1; (n * (n + 1) / 2) < MAX; n++) {
			tri.add(n * (n + 1) / 2);
		}

		for (long n = 1; (n * (3 * n - 1) / 2) < MAX; n++) {
			pen.add(n * (3 * n - 1) / 2);
		}

		for (long n = 1; (n * (2 * n - 1)) < MAX; n++) {
			hex.add(n * (2 * n - 1));
		}

		int triIndex = 0;
		int penIndex = 0;
		int hexIndex = 0;
		long i = 1;
		
		while (i < MAX) {
			boolean isTri = false;
			boolean isPen = false;
			boolean isHex = false;

			long nextTri = tri.get(triIndex);
			if (i < nextTri) {
				isTri = false;
			} else if (i == nextTri) {
				isTri = true;
				triIndex++;
			}

			long nextPen = pen.get(penIndex);
			if (i < nextPen) {
				isPen = false;
			} else if (i == nextPen) {
				isPen = true;
				penIndex++;
			}

			long nextHex = hex.get(hexIndex);
			if (i < nextHex) {
				isHex = false;
			} else if (i == nextHex) {
				isHex = true;
				hexIndex++;
			}

			if (isTri && isPen && isHex) {
				System.out.println(nextHex);
			}

			i++;

		}

	}

}
