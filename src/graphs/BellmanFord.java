package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BellmanFord {
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static String[] spl;

	static int n;
	static int m;

	static boolean[] isVisited;
	static int[] length;
	static Vertex[] vs;

	final static int X = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		spl = str.split(" ");
		n = Integer.parseInt(spl[0]);
		m = Integer.parseInt(spl[1]);
		
		length = new int[n + 1];
		Arrays.fill(length, X);
		
		vs = new Vertex[n + 1];
		for (int i = 1; i <= n; i++) {
			vs[i] = new Vertex(i);
		}
		
		for (int i = 0; i < m; i++) {
			str = br.readLine();
			spl = str.split(" ");
			vs[Integer.parseInt(spl[0])].addEdge(Integer.parseInt(spl[1]), Integer.parseInt(spl[2]));
		}
		
		length[1] = 0;
		for (int j = 0; j < n - 1; j++) {
			for (int k = 1; k <= n; k++) {
				Vertex v = vs[k];
				for (int l = 0; l < v.edges.size(); l++) {
					if (length[k] + v.edges.get(l).w < length[v.edges.get(l).to]) {
						length[v.edges.get(l).to] = (int) (length[k] + v.edges.get(l).w);
					}
				}
			}				
		}
		
		boolean hasCycle = false;
		for (int k = 1; k <= n; k++) {
			Vertex v = vs[k];
			for (int l = 0; l < v.edges.size(); l++) {
				if (length[k] + v.edges.get(l).w < length[v.edges.get(l).to]) {
					hasCycle = true; // there is a negative cycle
					break;
				}
			}
			if (hasCycle) {
				break;
			}
		}
		
		if (hasCycle) {
			System.out.println("There is a negative cycle");
		} else {
			for (int i = 1; i <= n; i++) {
				sb.append(length[i] + " ");
			}
			System.out.println(sb);
		}
	}
}