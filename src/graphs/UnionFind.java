package graphs;

public class UnionFind {

	public static int[] parent;
	
	public static void main(String[] args) {
		int[] arr = new int[1000];
		parent = new int[arr.length];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	public static void union(int x, int y) {
		if (find(x) == find(y)) {
			return;
		}
		parent[find(x)] = find(y);
	}

	public static int find(int x) {
		int c = x;
		while (c != parent[c]) {
			c = parent[c];
		}
		parent[x] = c;
		return c;
	}

}
