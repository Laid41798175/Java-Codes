package projectEuler;

import java.util.ArrayList;

public class Problem50 {

	public static void main(String[] args) {
		prime = new ArrayList<>();
		for (int i = 1; i < 1000000; i++) {
			if (isPrime(i)) prime.add(i);
		}
		System.out.println("done");
		
		int maxSum = 0;
		int maxNum = 0;
		for (int i = 0; i < 100; i++) {			
			if (consecutiveSum(i).maxNum > maxNum) {
				maxNum = consecutiveSum(i).maxNum;
				maxSum = consecutiveSum(i).sum;
			}
		}
		System.out.println(maxSum);
	}

	public static ArrayList<Integer> prime;
	
	public static boolean isPrime(int num) {
		if (num == 1) return false;
		if (num == 2) return true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	public static num2 consecutiveSum (int start) {
		int sum = 0;
		int maxSum = 0;
		int num = 0;
		int maxNum = 0;
		
		while (true) {
			sum += prime.get(start + num);
			num++;
			if (sum > 1000000) {
				break;
			} else {
				if (isPrime(sum)) {
					maxNum = num;
					maxSum = sum;
				}
			}
			
		}
		
		return new num2(maxNum, maxSum);
	}
}

class num2 {
	num2 (int a, int b){
		maxNum = a;
		sum = b;
	}
	int maxNum;
	int sum;
}
