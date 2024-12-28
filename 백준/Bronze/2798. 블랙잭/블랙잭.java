import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int N, M, arrN[];
    static int anwser;

    public static void init() throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrN = new int[N];
        anwser = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
    }

    public static void solution() {
        /*
        조합으로 3개 조합의 경우 만들어서 sum
        key값을 넘으면 패스, key값 이하중에 최댓값 저장
         */
        combi(0, 0, 0);
        System.out.println(anwser);
    }

    /*
    조합
     */
    public static void combi(int cnt, int start, int sum){
        //가지치기
        if (sum > M) return;

        if (cnt == 3) {
            anwser = Math.max(anwser, sum); // M 이하의 최대 합
            return;
        }
        // 조합 생성
        for (int i = start; i < N; i++) {
            if (sum + arrN[i] <= M)//가지치기
                combi(cnt + 1, i + 1, sum + arrN[i]);
        }
    }
    public static void main(String[] args) throws IOException{

        init();
        solution();
    }
}
