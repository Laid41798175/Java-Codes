package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloydWarshall {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static String[] spl;

	static int n;
	static int m;
	static int cost[][];
	
	final static int X = Integer.MAX_VALUE / 3;
	
	public static void main(String[] args) throws IOException {
		str = br.readLine();
		n = Integer.parseInt(str);
		cost = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(cost[i], X);
			cost[i][i] = 0;
		}
		
		str = br.readLine();
		m = Integer.parseInt(str);
		for (int i = 0; i < m; i++) {
			str = br.readLine();
			spl = str.split(" ");
			int x = Integer.parseInt(spl[0]);
			int y = Integer.parseInt(spl[1]);
			cost[x][y] = Math.min(cost[x][y], Integer.parseInt(spl[2]));
		}
		
		for (int k = 1; k <= n; k++) { // note that index k is on the top
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(cost[i][j] == X ? "INF " : (cost[i][j] + " "));
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}