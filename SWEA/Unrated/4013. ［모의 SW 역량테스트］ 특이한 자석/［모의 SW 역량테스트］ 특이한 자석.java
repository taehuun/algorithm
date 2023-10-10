import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();

	static int k, magnet[][], ro[][];
	static boolean visit[];

	static void init() throws IOException {

		k = Integer.parseInt(br.readLine());
		ro = new int[k][2];
		magnet = new int[4][8];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 8; j++) {
				magnet[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 0번 : 자석 번호, 1 : 방향
			ro[i][0] = Integer.parseInt(st.nextToken()) - 1;
			ro[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {

		// n극 : 0, s극 : 1
		// 시계방향 : 1, 반시계 -1
		for (int i = 0; i < k; i++) {
			visit = new boolean[4];
			check(ro[i][0], ro[i][1]);
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (magnet[i][0] == 1)
				sum += Math.pow(2, i);
		}
		sb.append(sum);
	}

	static void check(int num, int dir) {

		visit[num] = true;
		
		//왼쪽 검사
		if(num-1>=0 && magnet[num-1][2] != magnet[num][6] && !visit[num-1]) {
			check(num-1, dir*-1);
		}
		//오른쪽 검사
		if(num+1<4 && magnet[num+1][6]!=magnet[num][2] && !visit[num+1]) {
			check(num+1, dir*-1);
		}
		turn(num, dir);
	}

	static void turn(int num, int dir) {
		// n극 : 0, s극 : 1
		// 시계방향 : 1, 반시계 -1
		if(dir == 1) {
			int temp = magnet[num][7];
			for (int i = 7; i > 0; i--) {
				magnet[num][i] = magnet[num][i-1];
			}
			magnet[num][0] = temp;
		}
		else {
			int temp = magnet[num][0];
			for (int i = 1; i < 8; i++) {
				magnet[num][i-1] = magnet[num][i];
			}
			magnet[num][7] = temp;
		}
		
	}

	public static void main(String[] args) throws IOException {
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