package projectEuler;

public class Problem03 {

	public static void main(String[] args) {
		long a=600851475143l;
		for (int i=2; i<=a; i++) {
			if(prime(i)==true) {
				while(a%i==0) {
					a/=i;
					System.out.println(i);
					if(a==1) {
						System.out.println("end");
						System.exit(1);
					}
				}
			}
		}
	}

	public static boolean prime(int n) {
		int count=0;
		for( int i= 1; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				count++;
			}
		}
		if(count==1) {
			return true;
		} else {
			return false;
		}
	}

}
