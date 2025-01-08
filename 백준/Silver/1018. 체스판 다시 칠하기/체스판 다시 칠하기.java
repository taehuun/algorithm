import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[][] map;
    static int min;

    static void init() throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        map = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();

            for (int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) == 'W';
            }
        }
    }

    static void solution() {
        int row = N - 7;
        int col = M - 7;

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                min = Math.min(min, go(i, j));
            }
        }
        sb.append(min);
    }

    static int go(int startX, int startY) {
        int endX = startX + 8;
        int endY = startY + 8;
        int count = 0;

        boolean WB = map[startX][startY];

        for(int i=startX; i<endX; i++){
            for(int j=startY; j<endY; j++){

                if(WB != map[i][j])
                    count++;
                WB = !WB;
            }
            WB = !WB;
        }
        count = Math.min(count, 64 - count);
        return count;
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
