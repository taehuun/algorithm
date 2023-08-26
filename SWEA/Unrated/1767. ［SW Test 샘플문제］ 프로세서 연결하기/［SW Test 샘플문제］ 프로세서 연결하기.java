import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static class point {
		public int x, y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int T, N, size, min, map[][];
	static point core[];
	static boolean visit[];
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[12];
		core = new point[12];
		size = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1 && i>0 && j >0 && i<N-1 && j<N-1) { // 중앙에 위치한 코어만 추가
					core[size++] = new point(i, j);
				}
			}
		}
	}
	
	static void solve() {
		for (int i = size; i >= 0; i--) {
			combi(0, 0, i); // 조합으로 연결할 코어 개수 선택
			if(min < Integer.MAX_VALUE) break; // 최소 전선 길이를 찾았으면 종료
		}
		sb.append(min);
	}
	
	static void combi(int cnt, int start, int n) {
		if(cnt == n) {
			dfs(0, 0); // 선택한 코어 개수만큼 DFS로 전선 연결 시도
			return;
		}
		for (int i = start; i < size; i++) {
			visit[i] = true;
			combi(cnt+1, i+1, n); // 다음 코어 선택
			visit[i] = false;
		}
	}
	
	public static void dfs(int idx, int cnt) {
		if(idx == size) {
			min = Math.min(min, cnt); // 배열 끝까지 돌렸으면 이때의 최솟값 갱신
			return;
		}
		if(!visit[idx]) { // 부분 집합에 포함되는 애들만 다음 단계로 넘어갈 수 있다.
			dfs(idx + 1, cnt);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int x = core[idx].x, y = core[idx].y, tmp = 0;
			boolean success = false;
			while(true) {
				x += dx[i]; y += dy[i];
				if(x < 0 || x >= N || y < 0 || y >= N) { // 범위 끝까지 갔으면 성공
					success = true;
					break;
				}
				if(map[x][y] != 0) break; // 전선이나 코어를 만나면 실패
				map[x][y] = 2; // 전선 표시
				tmp++; // 전선 길이 합
			}
			if(success) dfs(idx + 1, cnt + tmp);
			while(true) { // 원 상태로 돌려놓기
				x -= dx[i]; y -= dy[i];
				if(x == core[idx].x && y == core[idx].y) break;
				map[x][y] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			init();
			solve();
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
