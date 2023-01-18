package projectEuler;

import java.util.ArrayList;

public class Problem47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		primeNumbers = new ArrayList<>();
		
		int count = 0;
		for (int i = 2; i < 1000000; i++) {
			if (primeFactors(i) == 4) {
				count++;
			} else {
				count = 0;
			}
			if (count == 4) {
				System.out.println(i - 3);
				break;
			}
		}
	}
	
	static ArrayList<Integer> primeNumbers;
	
	public static boolean isPrime(int num) {
		if (num == 1) return false;
		if (num == 2) return true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	
	public static int primeFactors(int num) {
		if (isPrime(num)) {
			primeNumbers.add(num);
			return 1;
		}
		int count = 0;
		int copy = num;
		for (int i = 0; i < primeNumbers.size(); i++) {
			int prime = primeNumbers.get(i);
			if (copy % prime == 0) {
				count++;
				while (copy % prime == 0) {
					copy /= prime;
				}
			}
			if (copy == 1) break;
		}
		return count;
	}
}
