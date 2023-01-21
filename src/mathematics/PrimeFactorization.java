package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrimeFactorization {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);
		if (n == 1) return;
		primeNumbers = new ArrayList<>();
		
		int prime = 2;
		primeNumbers.add(2);
		while (n != 1) {
			if (n % prime == 0) {
				 n /= prime;
				 System.out.println(prime);
			} else {
				prime++;
				while (!isPrime(prime)) prime++;
			}
		}
		
	}
	
	public static boolean isPrime (int number) {
		if (number == 1) return false;
		if (number == 2 || number == 3) {
			primeNumbers.add(number);
			return true;
		}
		
		int i = 0;
		while (primeNumbers.get(i) <= Math.sqrt(number)) {			
			if (number % primeNumbers.get(i) == 0) return false;
			i++;
		}
		// System.out.println(number + " is prime.");
		primeNumbers.add(number);
		return true;
	}
	
	static ArrayList<Integer> primeNumbers;

}
