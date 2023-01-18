package projectEuler;

public class Problem48 {

	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i <= 1000; i++) {
			long selfPower = power(i, i);
			sum = summation(sum, selfPower);
		}
		System.out.println(sum);
	}
	
	public static long multiply (long a, long b) {
		long mul = a * b;
		mul %= 10000000000l;
		return mul;
	}
	
	public static long power (long a, long b) {
		long pow = 1;
		for (int i = 0; i < b; i++) {
			pow = multiply (pow, a);
		}
		return pow;
	}
	
	public static long summation (long a, long b) {
		long sum = a + b;
		sum %= 10000000000l;
		return sum;
	}

}
