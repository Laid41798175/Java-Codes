package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Prim {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;
	static int m;
	
	static Loc[] star;
	static Edge[][] vertex;
	static boolean[] isVisited;

	static String str;
	static String[] spl;

	static double sum = 0;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		n = Integer.parseInt(str);
		star = new Loc[n];
		isVisited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			spl = str.split(" ");
			star[i] = new Loc(Double.parseDouble(spl[0]), Double.parseDouble(spl[1]));
		}
		
		vertex = new Edge[n][n];
		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j < n; j++) {
				double dst = star[i].distance(star[j]);
				vertex[i][j] = new Edge(j, dst);
				vertex[j][i] = new Edge(i, dst);
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (isVisited[e.to]) {
				continue;
			}
			
			isVisited[e.to] = true;
			sum += e.w;
			
			for (int i = 0; i < n; i++) {
				if (i != e.to) {
					pq.add(vertex[e.to][i]);
				}
			}
		}
		
		System.out.println(sum);
	}

}

class Loc {
	double x;
	double y;
	
	Loc (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(Loc o) {
		return Math.sqrt((x - o.x) * (x - o.x) + (y - o.y) * (y - o.y));
	}
}