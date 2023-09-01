import java.util.*;
import java.io.*;
public class Main {
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return this.x+" "+this.y;
		}
	}
	/*
	 * 맵으로 일단 입력 받음.
	 * for문 돌려서 첫 시작 x, y 저장
	 * 근데 첫 시작 x, y가 0이면 빙판이 없거나 전부 녹아서 없어진 경우다
	 * 그럴땐 0을 리턴
	 * bfs 들어가서 다 연결 되어 있는지 확인
	 * 연결 되어 있으면 start_x, start_y로 bfs로 빙판 녹이기
	 * 
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, M, map[][], start_x, start_y, bing_size, now_num;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static boolean visit[][], possible;
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		bing_size = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0) bing_size++;
			}
		}
	}
	
	static int solve() {
		
		int year = 0;		//몇년 걸리는지 정답 담을곳
		while(true) {
			start_x = 0;		//매번 초기화 하는 이유는 전부 녹아 없어지는 경우때문에
			start_y = 0;
			start_check();
			if(start_x == 0 && start_y == 0) return 0;
			visit = new boolean[N][M];
			if(bingsize() != bfs_line(start_x, start_y)) 
					return year;
			visit = new boolean[N][M];
			bfs(start_x, start_y);	//빙판 녹이는 메소드
			year++;
		}
		
	}
	
	static int bingsize() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>0) count++;
			}
		}
		return count;
	}
	
	//dfs시작점 구하는 메소드
	static void start_check() {		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>0) {
					start_x = i;
					start_y = j;
					return;
				}
			}
		}
	}
	//빙산 깍는 메소드
	static void bfs(int x, int y) {
		point start = new point(x, y);
		ArrayDeque<point> que = new ArrayDeque<>();
		visit[x][y] = true;
		que.offer(start);
		while(!que.isEmpty()) {
			point num = que.poll();
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int nx = num.x + dx[i];
				int ny = num.y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == 0 || visit[nx][ny]) {
					if(!visit[nx][ny]) {						
						count++;
					}
					continue;
				}
				visit[nx][ny] = true;
				que.offer(new point(nx, ny));
			}
			map[num.x][num.y] -= count;
			if(map[num.x][num.y] < 0)
				map[num.x][num.y] = 0; 
		}
	}
	//연결된 빙산 숫자 구하는 메소드
	static int bfs_line(int x, int y) {
		point start = new point(x, y);
		ArrayDeque<point> que = new ArrayDeque<>();
		visit[x][y] = true;
		que.offer(start);
		int count = 1;
		while(!que.isEmpty()) {
			point num = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = num.x + dx[i];
				int ny = num.y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == 0 || visit[nx][ny]) {
					continue;
				}
				visit[nx][ny] = true;
				que.offer(new point(nx, ny));
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException{
		init();
		System.out.println(solve());
	}

}