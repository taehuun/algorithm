import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static char map[][];
	static boolean visit[][];
	static int r, c, count_v, count_o;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}
	
	static void solve() {
		int sum_v = 0;
		int sum_o = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j]!='#' && !visit[i][j]) {
                    count_v = 0;
                    count_o = 0;
					dfs(i, j);
                    if (count_v >= count_o) {
                        sum_v += count_v;
                    } else {
                        sum_o += count_o;
                    }
				}
			}
		}
		System.out.println(sum_o + " " + sum_v);
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		if(map[x][y] == 'v') {
			count_v++;
		}
		else if(map[x][y] == 'o') {
			count_o++;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=r || ny<0 || ny>=c || map[nx][ny]=='#') continue;
			if(!visit[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
	}

}