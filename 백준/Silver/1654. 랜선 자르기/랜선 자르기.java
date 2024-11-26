import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int K, N, arrK[];
    static long low, high, mid;
    static void init() throws IOException {

        st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arrK = new int[K];
        low = 0;
        high = 0;
        mid = 0;
        for(int i=0; i<K; i++){
            arrK[i] = Integer.parseInt(br.readLine());
            //high값 최대로
            if(arrK[i] > high) high = arrK[i];
        }
    }

    static void solution() {

        /*
        랜선의 최대길이(int 최댓값)
        랜선의 최소길이(0)을 시작으로 이분 탐색 시작
        11개가 만들어지는 경우의 수 중에서 최댓값이 필요하니까 upperBound로
         */

        /*
        0~max 값을 범위로 탐색을 하는것이 아니라 0~max+1범위에서 탐색을 해야한다.
         */
        high++;

        while(low < high){

            mid = (low + high) / 2;

            int count = 0;

            for(int i=0; i<K; i++){
                count += (arrK[i] / mid);
            }

            if(count < N) high = mid;
            else low = mid + 1;
        }
        sb.append(high-1);
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
