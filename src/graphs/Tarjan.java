package graphs;

import java.io.*;
import java.util.*;

public class Tarjan {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringTokenizer stk;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int T;
	static int n;
	static int m;

	static Vertex[] vertex;
	static boolean[] isVisited;
	static boolean[] isSCC;

	static Stack<Integer> s = new Stack<>();
	static ArrayList<SCC> SCClist = new ArrayList<>();

	static int count = 0;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		vertex = new Vertex[n + 1];
		for (int i = 1; i <= n; i++) {
			vertex[i] = new Vertex();
		}
		isVisited = new boolean[n + 1];
		isSCC = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			vertex[Integer.parseInt(stk.nextToken())].edges.add(Integer.parseInt(stk.nextToken()));
		}

		for (int i = 1; i <= n; i++) {
			if (isVisited[i]) { // 이미 방문했다면 할 필요 없음
				continue;
			}
			dfs(i);
		}

		appendSCClist();
		System.out.print(sb);
	}

	public static int dfs(int curr) {
		vertex[curr].num = ++count; // 정점의 번호를 방문 순서대로 다시 붙여줌
		int ret = vertex[curr].num;
		s.push(curr); // 스택에 넣는 번호는 index임 (꺼내서 다시 원래 번호를 추측할 필요가 없음)
		isVisited[curr] = true;
		for (int i = 0; i < vertex[curr].edges.size(); i++) {
			int to = vertex[curr].edges.get(i);
			if (isSCC[to]) { // 이미 SCC의 요소라면 continue, 어차피 현재 노드는 그 SCC의 요소가 절대 아님
				continue;
			}

			if (!isVisited[to]) {
				ret = Math.min(ret, dfs(to)); // 방문 순서대로 붙였기 때문에 최솟값이 가장 부모 노드
			} else {
				ret = Math.min(ret, vertex[to].num); // 대상을 방문했다면 방문 순서를 얻어오면 됨, 방문하지 않았다면 dfs로 호출해서 알아오기
			}
		}

		if (ret == vertex[curr].num) { // 본인이 SCC에서 제일 낮은(먼저 방문한) 번호임
			SCC scc = new SCC();
			while (true) {
				int p = s.pop();
				scc.list.add(p);
				isSCC[p] = true;
				if (p == curr) { // 본인을 만날때까지 스택에서 꺼냄
					break;
				}
			}
			SCClist.add(scc);
		}

		return ret; // vertex[curr].num 의 최솟값을 반복해 제일 부모 노드를 리턴.
	}

	public static void appendSCClist() {
		sb.append("Number Of SCC: " + SCClist.size() + "\n");
		for (int i = 0; i < SCClist.size(); i++) {
			SCC scc = SCClist.get(i);
			sb.append("#" + (i + 1) + ": ");
			for (int j = 0; j < scc.list.size(); j++) {
				sb.append(scc.list.get(j) + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
	}

	static class SCC {
		ArrayList<Integer> list;

		SCC() {
			list = new ArrayList<>();
		}
	}

	static class Vertex {
		int num;
		ArrayList<Integer> edges;

		Vertex() {
			edges = new ArrayList<>();
		}
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int w;

		Edge(int t) {
			to = t;
			w = 1;
		}

		Edge(int t, int w) {
			to = t;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (w < o.w)
				return -1;
			else if (w == o.w)
				return 0;
			else
				return 1;
		}
	}
}
