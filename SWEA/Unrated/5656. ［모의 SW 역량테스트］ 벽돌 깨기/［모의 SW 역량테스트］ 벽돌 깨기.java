import java.util.*;
import java.io.*;

public class Solution {

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, W, H, map[][], copymap[][], min;
	static int num[];

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		num = new int[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		perm(0);
		sb.append(min);
	}

	// 중복순열 구하는 메소드
	static void perm(int cnt) {
		if (cnt == N) {
			// 맵 복사하는 영역
			copymap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			// =============
			play();
			return;
		}
		for (int i = 0; i < W; i++) {
			num[cnt] = i;
			perm(cnt + 1);
		}

	}

	// 시뮬레이션 메소드
	static void play() {
		int count = 0;
		int x = 0;
		int y = 0;

		for (int i = 0; i < N; i++) {
			y = num[i];

			for (int j = 0; j < H; j++) {
				if (copymap[j][y] > 0) {
					x = j;
					break;
				}
			}

			remove(x, y);
//			for (int j = 0; j < H; j++) {
//				for (int j2 = 0; j2 < W; j2++) {
//					System.out.print(copymap[j][j2] + " ");
//				}
//				System.out.println();
//			}
			down();
		}

		int sum = countmap(copymap);
		if (sum < min)
			min = sum;
	}

	// 폭탄 떨구는 메소드
	static void remove(int x, int y) {
		
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {x, y, copymap[x][y]});
		copymap[x][y] = 0;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int x1 = cur[0];
			int y1 = cur[1];
			int power = cur[2];
			
			for (int i = 0; i < power; i++) {
				for (int j = 0; j < 4; j++) {
					int nx = x1 + dx[j]*i;
					int ny = y1 + dy[j]*i;
					
					if(nx < 0 || nx>= H || ny<0 || ny>=W || map[nx][ny] == 0) continue;
					
					if(map[nx][ny] != 0) {
						que.offer(new int[] {nx, ny, copymap[nx][ny]});
						copymap[nx][ny] = 0;
					}
				}
			}
		}
		
		
//		System.out.println("x : "+x+" y : "+y);
//		int q = copymap[x][y];
//		copymap[x][y] = 0;
//		for (int i = 0; i < 4; i++) {
//			while (q > 1) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
//					if (copymap[nx][ny] > 0) {
//						remove(nx, ny);
//					}
//				}
//				q--;
//			}
//		}
	}

	// 맵에 폭탄 터트리고 떨구는 메소드
	static void down() {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if(copymap[j][i] != 0) {
					stack.push(copymap[j][i]);
				}
			}
			for (int j = H-1; j >= 0; j--) {
				if(stack.isEmpty()) {
					copymap[j][i] = 0;
				}
				else {
					copymap[j][i] = stack.pop();
				}
			}
		}
	}

	// 맵에 남아있는 벽돌 깨는 메소드
	private static int countmap(int[][] copymap2) {
		int sum = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copymap2[i][j] != 0)
					sum++;
			}
		}
		return sum;
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