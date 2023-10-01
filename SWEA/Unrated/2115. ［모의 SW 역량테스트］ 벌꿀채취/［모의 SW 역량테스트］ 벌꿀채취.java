import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, C, map[][], memo[][];
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		memo = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solve() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				go(i, j, 0, 0, 0);
			}
		}
		int max1 = 0;
		int max1_x = 0, max1_y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				if(max1 < memo[i][j]) {
					max1 = memo[i][j];
					max1_x = i;
					max1_y = j;
				}
			}
		}
		
		int max2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				if(max1_x == i && (max1_y < j+M || max1_y+M < j)) continue;
				if(max2 < memo[i][j]) {
					max2 = memo[i][j];
				}
			}
		}
		
		sb.append(max1+max2);
	}
	
	static void go(int x, int y, int idx, int sum, int total) {
		if(sum > C) return;
		if(idx == M) {
			if(memo[x][y] < total) {
				memo[x][y] = total;
			}
			return;
		}
		int val = map[x][y+idx];
		go(x, y, idx+1, sum+val, total+val*val);
		go(x, y, idx+1, sum, total);
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