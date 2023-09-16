import java.util.*;
import java.io.*;

public class Main {
    // 0, 2 -> 가로, 1, 2 -> 세로, 0, 1, 2 -> 대각선
    static int[] dy = {1, 0, 1};
    static int[] dx = {0, 1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N, map[][];
    static int count = 0;

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void dfs(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            count++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            // 현재 방향이 가로(0)일 때, 다음 방향은 가로(0) 또는 대각선(2)만 가능
            if (dir == 0 && (i == 1)) continue;
            // 현재 방향이 세로(1)일 때, 다음 방향 세로(1) 또는 대각선(2)만 가능
            if (dir == 1 && (i == 0)) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 1) {
                // 대각선 방향으로 이동할 때, 벽이 없어야 함
                if (i == 2 && (map[x + 1][y] == 1 || map[x][y + 1] == 1)) continue;
                dfs(nx, ny, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 1, 0);
        System.out.println(count);
    }
}