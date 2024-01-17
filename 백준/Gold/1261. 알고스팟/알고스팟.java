import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int map[][], memo[][];
	static int N, M, shoot;
	static boolean visit[][];

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		memo = new int[M][N];
		visit = new boolean[M][N];
		shoot = 0;
		for (int i = 0; i < M; i++) {
			char[] in = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = in[j] - '0';
			}
		}
	}

	static void solve() {

		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { 0, 0, 0 }); // x, y, shoot
		visit[0][0] = true;
		while (!que.isEmpty()) {
			int[] current = que.poll();
			int x = current[0];
			int y = current[1];
			int sh = current[2];

			if (x == M - 1 && y == N - 1) {
				shoot = sh;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (check(nx, ny) || visit[nx][ny])
					continue;

				visit[nx][ny] = true;

				if (map[nx][ny] == 1) {
					que.offerLast(new int[] { nx, ny, sh + 1 });
				} else {
					que.offerFirst(new int[] { nx, ny, sh });
				}
			}
		}
	}

	private static boolean check(int nx, int ny) {
		return nx < 0 || ny < 0 || nx >= M || ny >= N;
	}

	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println(shoot);
	}

	private static void checkmap(int[][] map) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}