import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[][] map;

    static void init() throws IOException {

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = ' ';
            }
        }
    }

    static void solution() {
        go(0, 0, N);

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }

    static void go(int x, int y, int n) {

        //종료조건
        if(n == 1){
            map[x][y] = '*';
            return;
        }

        //size가 1이 될때까지 3으로 계속 분할

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if(i==1 && j==1) continue;
                go(x+(i*n/3), y+(j*n/3), n/3);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init();
        solution();
        System.out.println(sb);
    }
}
