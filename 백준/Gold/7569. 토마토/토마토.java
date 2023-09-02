import java.util.*;
import java.io.*;

public class Main {
    
    static class Point {
        int x, y, h;

        public Point(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", h=" + h + "]";
        }
    }

    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {0, 0, 0, 0, 1, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N, M, H, map[][][], day, num;
    static boolean hasFreshTomato;
    static ArrayDeque<Point> tomato;
    static ArrayDeque<Point> que;

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new ArrayDeque<>();
        map = new int[H][N][M];
        day = 0;
        num = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        tomato.offer(new Point(h, n, m));
                    } else if (map[h][n][m] == 0) {
                        num++;
                    }
                }
            }
        }
    }

    static int solve() {
        while (!tomato.isEmpty()) {
            int tomato_size = tomato.size();
            hasFreshTomato = false; // 새로 익을 토마토가 있는지 체크

            for (int i = 0; i < tomato_size; i++) {
                Point q = tomato.poll();
                bfs(q.h, q.x, q.y);
            }

            day++;

           if(num > 0 && !hasFreshTomato) return -1;
        }

       return num == 0 ? day -1 : -1;
    }
    	
    static void bfs(int h, int x, int y) {
        for (int i = 0; i < 6; i++) {
            int nh = h + dh[i];
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nh >= 0 && nh < H && nx >= 0 && nx < N && ny >= 0 && ny < M && map[nh][nx][ny] == 0) {
                map[nh][nx][ny] = 1;
                tomato.offer(new Point(nh, nx, ny));
                hasFreshTomato = true; // 새로 익은 토마토가 있음을 표시
                num--; // 미익은 토마토의 개수 감소
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }
}