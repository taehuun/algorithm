import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, numbers[];
	static boolean visit[];
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		visit = new boolean[N+1];
	}
	
	static void prem(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			numbers[cnt] = i;
			prem(cnt+1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		prem(0);
	}

}