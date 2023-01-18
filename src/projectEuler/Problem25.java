package projectEuler;

public class Problem25 {
	
	public static void main(String[] args) {
		int digita[] = new int[1000];
		int digitb[] = new int[1000];
		int digitc[] = new int[1000];
		digita[0] = 1;
		digitb[0] = 1;
		digitc[0] = 2;
		int count = 3;
		while (true) {
			for (int i = 0; i < digita.length; i++) {
				digita[i] = digitb[i] + digitc[i];
			}
			digita=carry(digita);
			count=check(count,digita);
			for (int i = 0; i < digitb.length; i++) {
				digitb[i] = digitc[i] + digita[i];

			}
			digitb=carry(digitb);
			count=check(count,digitb);
			for (int i = 0; i < digitc.length; i++) {
				digitc[i] = digita[i] + digitb[i];
			}
			digitc=carry(digitc);
			count=check(count,digitc);
		}
	}
	
	public static int[] carry(int n[]) {
		for (int i=0; i<n.length; i++) {
			if(n[i]>=10) {
				n[i+1]++;
				n[i]%=10;
			}
		}
		return n;
	}
	
	public static int check(int a, int n[]) {
		a++;
		if(n[999]!=0) {
			System.out.println(a);
			System.exit(1);
		}
		return a;
	}

}