package graphs;

//Do Not Modify From
import java.io.*;
import java.util.*;

public class Kruskal {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringTokenizer stk;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int T;
	static int n;
	static int m;
	// Do Nod Modify To
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		Queue<Edge> q = new PriorityQueue<>(); // Heap Sort
		for (int i = 0; i < m; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			q.add(new Edge(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
					Integer.parseInt(stk.nextToken())));
		}

		ArrayList<Edge> MST = MST(q);
		System.out.println(MST);
	}
	
	public static ArrayList<Edge> MST(Queue<Edge> edges) {
		ArrayList<Edge> ret = new ArrayList<>();
		
		int count = 0;
		try {
			while (count < n - 1) { // MST의 Edge 개수
				Edge e = edges.poll();			
				if (find(e.from) == find(e.to)) {
					continue;
				} else {
					union(e.from, e.to);
					ret.add(e);
					count++;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Cannot make a MST");
		}
		
		return ret;
	}

	public static int find(int x) {
		int c = x;
		while (c != parent[c]) {
			c = parent[c];
		}
		parent[x] = c;
		return c;
	}

	public static void union(int x, int y) {
		if (find(x) == find(y)) {
			return;
		}
		parent[find(x)] = find(y);
	}
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int w;

		Edge(int f, int t, int w) {
			from = f;
			to = t;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return w - o.w;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			return sb.append(from).append("-").append(to).append(" : ").append(w).toString();
		}
	}
}