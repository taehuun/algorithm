import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int a, b, c, d, e, f;

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
    }

    static void solution() {
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                // 두 방정식의 해인지 확인
                if (a * x + b * y == c && d * x + e * y == f) {
                    sb.append(x).append(" ").append(y);
                    return; // 해를 찾으면 종료
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
