import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class point {
        public int x, y;
        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    /**
     * 가로길이 M(1 ≤ M ≤ 50)
     * 세로길이 N(1 ≤ N ≤ 50)
     * 배추개수 K(1 ≤ K ≤ 2500)
     */
    static int m, n, k;
    static int[][] map;
    static boolean[][] visit;

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            /**
             * 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)
             */
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }


    }

    static void solve() {
        int count = 0;
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !visit[i][j]){
//                    bfs(i, j);
                    dfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for (int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(check(nx, ny) || visit[nx][ny]) continue;
            if(map[nx][ny] == 1) dfs(nx, ny);
        }
    }

    static void bfs(int x, int y){
        visit[x][y] = true;
        Queue<point> que = new ArrayDeque<>();
        que.offer(new point(x,y));
        while(!que.isEmpty()){
            point p = que.poll();
            for(int dir=0; dir<4; dir++){
                int nx = p.x+dx[dir];
                int ny = p.y+dy[dir];
                if(check(nx, ny) || visit[nx][ny]) continue;
                if(map[nx][ny] == 1){
                    visit[nx][ny] = true;
                    que.offer(new point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            init();
            solve();
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static boolean check(int nx, int ny){
        return nx<0 || ny<0 || nx>=n || ny>=m;
    }
}
