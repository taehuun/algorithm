import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int n, m, v, a, b;

	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(arr[i]);
		}
	}
	
	private static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		
		for (int i : arr[v]) {
			if(!visit[i]) {
				dfs(i);
			}
		}
	}
	
	private static void bfs() {
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.offer(v);
		visit[v] = true;
		while(!que.isEmpty()) {
			int curr = que.poll();
			System.out.print(curr + " ");
			for (int i : arr[curr]) {
				if(!visit[i]) {
					que.offer(i);
					visit[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		visit = new boolean[n+1];
		dfs(v);
		System.out.println();
		visit = new boolean[n+1];
		bfs();
		System.out.println();
	}

}