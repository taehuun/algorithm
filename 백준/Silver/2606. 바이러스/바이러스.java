import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, M, count;
	static ArrayList<Integer>[] list;
	static boolean visit[];
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		count = 0;
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
	}
	
	static void dfs(int v) {
		visit[v] = true;
		count++;
		for (int i : list[v]) {
			if(!visit[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		dfs(1);
		System.out.println(count-1);
	}

}