package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j <= n; j++) {
				Vertex v = vs[j];
				for (int k = 0; k < v.edges.size(); k++) {
					if (length[j] + v.edges.get(k).w < length[v.edges.get(k).to]) {
						length[v.edges.get(k).to] = (int) (length[j] + v.edges.get(k).w);
					}
				}
			}				
		}
		
		boolean hasCycle = false;
		for (int i = 1; i <= n; i++) {
			Vertex v = vs[i];
			for (int j = 0; j < v.edges.size(); j++) {
				if (length[i] + v.edges.get(j).w < length[v.edges.get(j).to]) {
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
	
	static class Vertex {
		int num;
		ArrayList<Edge> edges;

		Vertex(int n) {
			num = n;
			edges = new ArrayList<>();
		}

		public void addEdge(int to, int w) {
			edges.add(new Edge(to, w));
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int to;
		int w;

		Edge(int t, int w) {
			to = t;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return w - o.w;
		}
	}
}