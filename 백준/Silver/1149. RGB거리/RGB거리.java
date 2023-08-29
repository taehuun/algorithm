import java.util.*;
import java.io.*;
public class Main {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, map[][];
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solve() {
		int[][] sum = new int[N][3];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			sum[0][i] = map[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if(k==j) continue;
					int a = sum[i-1][j] + map[i][k];
					if(sum[i][k] == 0) {
						sum[i][k] = a;
					}
					else {
						sum[i][k] = Math.min(sum[i][k], a);
					}
				}
			}
		}
		min = Math.min(sum[N-1][0], sum[N-1][1]);
		min = Math.min(min, sum[N-1][2]);
		System.out.println(min);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
	}

}