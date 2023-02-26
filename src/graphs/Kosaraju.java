package graphs;

import java.io.*;
import java.util.*;

public class Kosaraju {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringTokenizer stk;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int T;
	static int n;
	static int m;

	static Vertex[] graph;
	static Vertex[] rgraph;
	static boolean[] isVisited;

	static Stack<Integer> s = new Stack<>();
	static ArrayList<ArrayList<Integer>> SCClist = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		graph = new Vertex[n + 1];
		rgraph = new Vertex[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new Vertex();
			rgraph[i] = new Vertex();
		}
		isVisited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			graph[a].edges.add(b);
			rgraph[b].edges.add(a);
		}

		for (int i = 1; i <= n; i++) {
			if (!isVisited[i]) {
				dfs(i);
			}
		}

		isVisited = new boolean[n + 1];
		while (!s.isEmpty()) {
			int i = s.pop();
			if (isVisited[i]) {
				continue;
			}
			scc = new ArrayList<Integer>();
			dfsRev(i);
			SCClist.add(scc);
		}

		System.out.println(SCClist.toString());
	}

	static ArrayList<Integer> scc;

	static void dfs(int curr) {
		isVisited[curr] = true;
		for (int to : graph[curr].edges) {
			if (!isVisited[to]) {
				dfs(to);
			}
		}
		s.push(curr);
	}

	static void dfsRev(int curr) {
		isVisited[curr] = true;
		scc.add(curr);
		for (int to : rgraph[curr].edges) {
			if (!isVisited[to]) {
				dfsRev(to);
			}
		}
	}

	static class Vertex {
		int num;
		ArrayList<Integer> edges;

		Vertex() {
			edges = new ArrayList<>();
		}
	}
}