import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int N, C, arrN[];
    static int low, high, mid;

    static void init() throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        low = 1;
        high = 0;

        arrN = new int[N];

        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arrN);

        high = arrN[N-1] - arrN[0] + 1;
    }

    static void solution() {
        /*
        최대거리를 찾는거니까 upperBound로 최대거리 찾고
        최대 거리일때 count = C인지 확인하기
         */
        while(low < high){
            mid = (low + high) / 2;

            if(install(mid) < C) high = mid;
            else low = mid + 1;
        }
        sb.append(low-1);
    }

    static int install(int dis) {

        int count = 1;
        int lastInstallH = arrN[0];

        for(int i=1; i<N; i++){
            int installH = arrN[i];

            if((installH - lastInstallH) >= dis){
                count++;
                lastInstallH = installH;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
