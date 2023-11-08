import java.io.*;
import java.util.*;

public class Solution {

	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, map[][], max;
	static boolean visit[];
	static int startX, startY;

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		max = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < N - 1; j++) {
				startX = i;
				startY = j;
				visit = new boolean[101];
				visit[map[i][j]] = true;
				go(i, j, 0, 1);
			}
		}
		sb.append(max);
	}

	static void go(int x, int y, int dir, int cnt) {

		for (int i = dir; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (check(nx, ny)) {
				continue;
			}

			if (nx == startX && ny == startY && cnt>2) {
				max = Math.max(max, cnt);
				return;
			}
			
			if(visit[map[nx][ny]])
				continue;
			
			visit[map[nx][ny]] = true;
			go(nx, ny, i, cnt+1);
			visit[map[nx][ny]] = false;
		}
	}

	private static boolean check(int x, int y) {

		return x < 0 || x >= N || y < 0 || y >= N;
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