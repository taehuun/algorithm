import java.util.*;
import java.io.*;
public class Solution {
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, map[][];
	static int start_x, start_y;
	static int end_x, end_y;
	static boolean visit[][];
	static int q = 1;
	
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		start_x = Integer.parseInt(st.nextToken());
		start_y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		end_x = Integer.parseInt(st.nextToken());
		end_y = Integer.parseInt(st.nextToken());
	}
	
	static int bfs() {
		int cnt = 0;
		Queue<int[]> que = new ArrayDeque<int[]>();
		int[] point = {start_x, start_y};
		visit[start_x][start_y] = true;
		que.offer(point);
		while(!que.isEmpty()) {
			//( 0 : 지나갈 수 있는 곳 , 1 : 장애물 , 2: 주기가 2초인 소용돌이)
			int size = que.size();
			for (int s = 0; s < size; s++) {
				int[] p = que.poll();
				int x = p[0];
				int y = p[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(check(nx, ny) || map[nx][ny] == 1 || visit[nx][ny]) continue;
					if(nx==end_x && ny==end_y) return cnt+1;
					if(map[nx][ny]==2 && cnt%3!=2) {
//						System.out.println(q + " nx : "+nx + " ny : " + ny);
						que.offer(p);
						continue;
					}
					visit[nx][ny] = true;
					que.offer(new int[] {nx, ny});
				}
			}
			cnt++;
		}

		return -1;
	}

	private static boolean check(int nx, int ny) {
		
		return nx<0 || nx>=N || ny<0 || ny>=N;
	}

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			init();
			int answer = bfs();
			q++;
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}