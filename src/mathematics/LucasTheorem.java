package mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LucasTheorem {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static int m;

	static String str;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		BigInteger N = new BigInteger(stk.nextToken());
		BigInteger K = new BigInteger(stk.nextToken());
		BigInteger M = new BigInteger(stk.nextToken()); // M is a prime
		int m = Integer.parseInt(M.toString());
		
		Queue<Integer> nString = new LinkedList<>();
		while (N.compareTo(BigInteger.ZERO) != 0) {
			nString.add(N.remainder(M).intValue());
			N = N.divide(M);
		}
		
		Queue<Integer> kString = new LinkedList<>();
		while (K.compareTo(BigInteger.ZERO) != 0) {
			kString.add(K.remainder(M).intValue());
			K = K.divide(M);
		}
		
		long ans = 1;
		while (!nString.isEmpty()) {
			int n = nString.poll();
			int k = kString.isEmpty() ? 0 : kString.poll();
			ans *= nCk(n, k, m);
			ans %= m;
		}
		System.out.println(ans);
	}
	
	public static long nCk(int n, int k, int x) {
		if (n < k) {
			return 0;
		}
		
		long rem0 = 1;
		for (int i = 1; i <= n; i++) {
			rem0 = (rem0 * i) % x;
		}
		
		long rem1 = 1;
		for (int i = 1; i <= k; i++) {
			rem1 = (rem1 * i) % x;
		}
		for (int i = 1; i <= (n - k); i++) {
			rem1 = (rem1 * i) % x;
		}
		
		BigInteger tmp = BigInteger.valueOf(rem1);
		BigInteger inv = tmp.modInverse(BigInteger.valueOf(x));
		return (rem0 * inv.longValue()) % x;
	}
}