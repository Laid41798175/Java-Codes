package projectEuler;

public class Problem12 {

	public static void main(String[] args) {
		int n=1;
		int add=2;
		while(divisor(n)<=500){
			n+=add;
			add++;
		}
		System.out.println(n);

	}
	
	public static int divisor(int n){
		int count=0;
		for(int i=1; i<=Math.sqrt(n); i++){
			if(n%i==0){
				count+=2;
			}	
		}
		if(Math.sqrt(n)==(int)Math.sqrt(n)){
			count--;
		}
		return count;
	}

}