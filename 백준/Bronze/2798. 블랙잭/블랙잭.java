import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static int N, M, arrN[];
    static int anwser;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrN = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);
        anwser = 0;
    }

    public static void solution() {
        /*
        조합으로 3개 조합의 경우 만들어서 sum
         */
        combi(0, 0, 0);
        System.out.println(anwser);
    }

    public static void combi(int cnt, int start, int sum) {
        if (sum > M) return; // 현재 합이 M을 초과하면 탐색 종료

        if (cnt == 3) {
            anwser = Math.max(anwser, sum); // M 이하의 최대 합 업데이트
            return;
        }

        for (int i = start; i < N; i++) {
            // 남은 값과 현재 sum의 합이 M보다 작거나 같을 경우만 탐색
            if (sum + arrN[i] <= M) {
                combi(cnt + 1, i + 1, sum + arrN[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }
}