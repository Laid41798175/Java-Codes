package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static String[] spl;

	static int v;
	static int e;

	static int start;
	static boolean[] isVisited;
	static int[] length;
	static Vertex[] vs;

	final static int X = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		spl = str.split(" ");
		v = Integer.parseInt(spl[0]);
		e = Integer.parseInt(spl[1]);

		isVisited = new boolean[v + 1];
		length = new int[v + 1];
		Arrays.fill(length, X);

		vs = new Vertex[v + 1];
		for (int i = 1; i <= v; i++) {
			vs[i] = new Vertex(i);
		}

		str = br.readLine();
		start = Integer.parseInt(str);
		length[start] = 0;

		for (int i = 0; i < e; i++) {
			str = br.readLine();
			spl = str.split(" ");
			vs[Integer.parseInt(spl[0])].addEdge(Integer.parseInt(spl[1]), Integer.parseInt(spl[2]));
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		pq.add(new Pair(0, start));		
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (isVisited[p.vertex]) continue;
			isVisited[p.vertex] = true;
			for (int i = 0; i < vs[p.vertex].edges.size(); i++) {
				Edge e = vs[p.vertex].edges.get(i);
				if (!isVisited[e.to] && length[p.vertex] + e.w < length[e.to]) {
					length[e.to] = length[p.vertex] + e.w;
					pq.add(new Pair(length[e.to], e.to));
				}
			}
		}		
		
		for (int i = 1; i <= v; i++) {
			sb.append(length[i] == X ? "INF\n" : (length[i] + "\n"));
		}
		System.out.print(sb);
	}
}

class Pair implements Comparable<Pair> {
	int length;
	int vertex;
	
	Pair (int length, int index) {
		this.length = length;
		vertex = index;
	}

	@Override
	public int compareTo(Pair o) {
		if (length < o.length) {
			return -1;
		} else if (length == o.length) {
			return 0;
		} else {
			return 1;
		}
	}
}

class Vertex {
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

class Edge {
	int to;
	int w;

	Edge(int t, int w) {
		to = t;
		this.w = w;
	}
}