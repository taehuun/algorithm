import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, numbers[], list[];
	static boolean visit[];
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		list = new int[N];
		visit = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
	}
	
	static void prem(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			numbers[cnt] = list[i];
			prem(cnt+1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		prem(0);
		System.out.println(sb);
	}

}