import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int arr[], answer[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static void init() throws IOException{

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        //for문을 돌면서 첫번째 꺼부터 이분탐색으로 보냄
        for (int i=0; i<M; i++){
            if(binary(answer[i], 0, arr.length-1) == 1) sb.append(1).append("\n");
            else sb.append(0).append("\n");

        }
    }

    static int binary(int key, int low, int high){
        if (low > high) {
            return 0;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == key) return 1;
        else if (arr[mid] > key) return binary(key, low, mid - 1);
        else return binary(key, mid + 1, high);
    }

    public static void main(String[] args) throws IOException{
        init();
        solution();
        System.out.println(sb);

    }
}