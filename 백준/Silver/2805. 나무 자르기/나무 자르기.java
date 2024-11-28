import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long M, arrN[];
    static long low, high, mid;

    static void init() throws IOException {

        low = 0;
        high = 0;
        mid = 0;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrN = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
            if(arrN[i] > high) high = arrN[i];
        }

    }

    static void solution() {

        /*
        lowerBound사용해서
        탐색하면 될듯
        최소는 0
        최대는 arrN중에 최대로 하고
         */
        while(low < high){

            long sum = 0;

            mid = (low+high) / 2;

            for(int i=0; i<N; i++){

                if((arrN[i] - mid) > 0){
                    sum += (arrN[i] - mid);
                }

            }

            if(M <= sum) low = mid+1;
            else high = mid;
        }

        sb.append(low-1);

    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
