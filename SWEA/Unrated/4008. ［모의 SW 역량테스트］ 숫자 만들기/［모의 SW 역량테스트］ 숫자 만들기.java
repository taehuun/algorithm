import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, oper[], num[], max, min;
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		oper = new int[4];
		num = new int[N];
		max = Integer.MIN_VALUE;
		min  = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		
		go(1, num[0]);
		sb.append(max - min);
	}
	
	static void go(int idx, int val) {
		if(idx == N) {		//종료조건
			if(max < val) max = val;
			if(min > val) min = val;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(oper[i]>0) {
				oper[i]--;
				
				switch (i) {
				case 0: go(idx+1, val+num[idx]); break;
				case 1: go(idx+1, val-num[idx]); break;
				case 2: go(idx+1, val*num[idx]); break;
				case 3: go(idx+1, val/num[idx]); break;
				}
				oper[i]++;
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			init();
			solve();
			sb.append("\n");
		}
		System.out.println(sb);
	}

}