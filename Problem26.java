package projectEuler;

import java.util.*;

public class Problem26 {

	public static void main(String[] args) {
		
		int maxD = 0;
		int maxReciprocal = 0;
		
		
		for (int i = 2; i < 1000; i++) {
			int temp = reciprocal(i);
			if (temp > maxReciprocal) {
				maxD = i;
				maxReciprocal = temp;
			}
		}

		System.out.println("d: " + maxD);
		System.out.println("length is: "+ maxReciprocal);
		

	}

	public static int reciprocal(int d) {
		int recip = 0;
		int A = 1;
		List<Integer> Alist = new ArrayList<Integer>();

		while (true) {
			if (A % d != 0) {
				A *= 10;
				int count = 0;
				for (int As : Alist) {
					
					if (As == A) {
						return recip - count;
					}
					count ++;
				}
				Alist.add(A);
				
				recip += 1;
					A %= d;
				
				// System.out.print(A);

			} else {
				return 0;
			}
		}
	}

}
