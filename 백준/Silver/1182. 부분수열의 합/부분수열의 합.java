import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, S, num[], count;
	static boolean visit[];
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N];
		visit = new boolean[N];
		count = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void powerSet(int idx, int size, int sum) {
		if(idx == N) {
			if(size>0 && sum == S) count++;
			return;
		}
		visit[idx] = true;
		powerSet(idx+1, size+1, sum+num[idx]);
		visit[idx] = false;
		powerSet(idx+1, size, sum);
		
	}
	
	public static void main(String[] args) throws IOException{
		init();
		powerSet(0, 0, 0);
		System.out.println(count);
	}

}