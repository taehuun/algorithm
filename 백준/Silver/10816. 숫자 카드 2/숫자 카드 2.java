import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int N, M, arrN[], arrM[];

    static void init () throws IOException{
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<M; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution(){

        Arrays.sort(arrN);

        for(int i=0; i<M; i++){
            sb.append(upperBound(arrM[i]) - lowerBound(arrM[i])).append(" ");
        }
    }

    static int upperBound(int key){
        int low = 0;
        int high = arrN.length;

        while(low < high){

            int mid = (low + high) / 2;

            if(key < arrN[mid]) high = mid;
            else low = mid+1;
        }

        return high;
    }

    static int lowerBound(int key){
        int low = 0;
        int high = arrN.length;

        while(low < high){

            int mid = (low + high)/2;

            if(key <= arrN[mid]) high = mid;
            else low = mid+1;
        }

        return low;
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
