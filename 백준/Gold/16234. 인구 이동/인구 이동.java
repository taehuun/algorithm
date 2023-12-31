import java.util.*;
import java.io.*;

public class Main {

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int answer; // 정답
	static int N, L, R;
	static int A[][];
	static boolean visit[][], flag;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		// 초기화
		A = new int[N][N];
		visit = new boolean[N][N];
		answer = 0;
		flag = true;
		////////
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		/*
		 * 일단 플래그 만들어서 참이면 계속 돌고 한바퀴 돌때마다 answer++ 
		 * 0,0부터 쭉 확인해서 일단 이동 가능한 부분 전부 true로 만들기
		 * true인 부분중에 연결여부 확인하고 연결 되어 있으면 더하기
		 */
		while (flag) {
			flag = false;
			visit = new boolean[N][N];
			move();
			if(!flag) break;
			answer++;
		}
	}
	//국경선 연결
	static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) bfs(i, j);
			}
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> que = new ArrayDeque<>();
		ArrayList<int[]> list = new ArrayList<>();
		
		int sum = 0;
		int cnt = 0;
		
		que.offer(new int[] {i, j});
		visit[i][j] = true;
		list.add(new int[] {i, j});
		
		while(!que.isEmpty()) {
			int[] q = que.poll();
			cnt++;
			sum += A[q[0]][q[1]];
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = q[0] + dx[dir];
				int ny = q[1] + dy[dir];
				
				//범위 확인
				if(check(nx, ny) || visit[nx][ny]) continue;
				int diff = Math.abs(A[q[0]][q[1]] - A[nx][ny]);
				if(diff>=L && diff<=R) {
					que.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					list.add(new int[] {nx, ny});
					
				}
			}
		}
		if(cnt > 1) {
			flag = true;
			
			for (int[] num : list) {
				A[num[0]][num[1]] = sum/cnt;
			}
		}
	}

	private static boolean check(int nx, int ny) {
		return nx < 0 || nx >= N || ny < 0 || ny >= N;
	}

	public static void main(String[] args) throws IOException {

		init();
		solve();
		System.out.println(answer);
	}

}