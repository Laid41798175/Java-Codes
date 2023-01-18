package projectEuler;

public class Problem49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1000; i < 10000; i++) {
			if (!isPrime(i)) continue;
			int[] per = permutations(i);
			for (int j = 1; j < 24; j++) {
				if (!isPrime(per[j]) || per[j] < 1000) continue;
				int n0 = 2 * i - per[j];
				int n1 = 2 * per[j] - i;
				if (1000 <= n0 && n0 < 10000 &&
						isPrime(n0) && isPermutation(i, n0) && n0!=n1) {
					System.out.println(i+""+per[j]+""+n0);
				}
				if (1000 <= n1 && n1 < 10000 &&
						isPrime(n1) && isPermutation(i, n1) && n0!=n1) {
					System.out.println(i+""+per[j]+""+n1);
				}
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if (num == 1) return false;
		if (num == 2) return true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	

	public static int[] permutations (int num) {
		int d0 = num / 1000;
		int d1 = num % 1000 / 100;
		int d2 = num % 100 / 10;
		int d3 = num % 10;
		int[] ret = new int [24];
		ret[0] = number(d0, d1, d2, d3);
		ret[1] = number(d0, d1, d3, d2);
		ret[2] = number(d0, d2, d1, d3);
		ret[3] = number(d0, d2, d3, d1);
		ret[4] = number(d0, d3, d1, d2);
		ret[5] = number(d0, d3, d2, d1);
		ret[6] = number(d1, d0, d2, d3);
		ret[7] = number(d1, d0, d3, d2);
		ret[8] = number(d1, d2, d0, d3);
		ret[9] = number(d1, d2, d3, d0);
		ret[10] = number(d1, d3, d0, d2);
		ret[11] = number(d1, d3, d2, d0);
		ret[12] = number(d2, d0, d1, d3);
		ret[13] = number(d2, d0, d3, d1);
		ret[14] = number(d2, d1, d0, d3);
		ret[15] = number(d2, d1, d3, d0);
		ret[16] = number(d2, d3, d0, d1);
		ret[17] = number(d2, d3, d1, d0);
		ret[18] = number(d3, d0, d1, d2);
		ret[19] = number(d3, d0, d2, d1);
		ret[20] = number(d3, d1, d0, d2);
		ret[21] = number(d3, d1, d2, d0);
		ret[22] = number(d3, d2, d0, d1);
		ret[23] = number(d3, d2, d1, d0);
		return ret;		
	}
	
	public static int number (int d0, int d1, int d2, int d3) {
		return d0 * 1000 + d1 * 100 + d2 * 10 + d3;
	}
	
	public static boolean isPermutation (int a, int b) {
		int[] digitA = new int [10];
		int[] digitB = new int [10];
		for (int i = 0; i < 10; i++) {
			digitA[i] = 0;
			digitB[i] = 0;
		}
		digitA[a / 1000]++;
		digitA[a % 1000 / 100]++;
		digitA[a % 100 / 10]++;
		digitA[a % 10]++;
		
		digitB[b / 1000]++;
		digitB[b % 1000 / 100]++;
		digitB[b % 100 / 10]++;
		digitB[b % 10]++;
		for (int i = 0; i < 10; i++) {
			if (digitA[i] != digitB[i]) return false;
		}
		return true;
	}
}
