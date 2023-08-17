import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int r, c, count;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 0, 1};
	
	private static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}
	
	private static void solve() {
		count = 0;
		for (int i = 0; i < r; i++) {
			visit[i][0] = true;
			go(i, 0);			
		}
		sb.append(count);
	}
	
	private static boolean go(int x, int y) {
		if(y==c-1) {
			count++;
			return true;
		}
		int nx = x;
		int ny = y+1;
		for (int i = 0; i < 3; i++) {
			nx =x + dx[i];
			if(nx<0 || nx>=r || ny>=c || map[nx][ny]=='x' || visit[nx][ny]==true) {
				continue;
			}
			visit[nx][ny] = true;
			if(go(nx, ny)) {
				return true;
			}
		}
		return false;
	}
	private static void print() {
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		print();
	}

}
