import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	// 정점 갯수, 간선 갯수, 시작점
	static ArrayList<Integer>[] list;
	static boolean visit[];
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
	}
	
	static void dfs(int v) {
		sb.append(v).append(" ");
		visit[v] = true;
		for (int i : list[v]) {
			if(!visit[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		ArrayDeque<Integer> que = new ArrayDeque<>();
		visit[V] = true;
		que.offer(V);
		while(!que.isEmpty()) {
			int a = que.poll();
			sb.append(a).append(" ");
			for (int i : list[a]) {
				if(!visit[i]) {
					visit[i] = true;
					que.offer(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		visit = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs();
		System.out.println(sb);
	}

}