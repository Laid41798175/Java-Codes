package projectEuler;

public class Problem15 {

	public static void main(String[] args) {
		double nCr = 1;
		for (int i = 40; i >= 21; i--) {
			nCr *= i;
			nCr /= i - 20;
		}
		long Casted=(long) nCr+1; // Casting은 반올림이 아니라 버림.
		System.out.println(Casted);
	}

}