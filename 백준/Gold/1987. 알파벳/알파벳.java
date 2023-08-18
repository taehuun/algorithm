import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int r, c, x, y, count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[] visited;

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    static int dfs(int x, int y, int count) {
        int currentCount = count;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int idx = (int) (map[nx][ny]) - 'A';

                if (!visited[idx]) {
                    visited[idx] = true;
                    currentCount = Math.max(currentCount, dfs(nx, ny, count + 1));
                    visited[idx] = false;
                }
            }
        }

        return currentCount;
    }

    static void solve() {
        visited[(int) (map[0][0]) - 'A'] = true;
        count = dfs(0, 0, 1); // DFS 시작

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
}
