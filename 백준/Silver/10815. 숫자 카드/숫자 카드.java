import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, get[], M, num;
	static boolean find;
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		get = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			get[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(get);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			find = false;
			solve(Integer.parseInt(st.nextToken()));
			if(find) sb.append(1).append(" ");
			else sb.append(0).append(" ");
		}
	}
	
	static void solve(int target) {
		int start = 0;
		int end = N-1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(target == get[mid]) {
				find = true;
				return;
			}
			if(target < get[mid]) {
				end = mid-1;
			}
			else if(target > get[mid]) {
				start = mid+1;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		init();
		System.out.println(sb);
	}

}