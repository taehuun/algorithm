import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] A, tmp;
    static int count, result;

    static void init() throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        tmp = new int[N];
        count = 0;
        result = -1;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {

        merge_sort(A, 0, N-1);
        sb.append(result);
    }

    static void merge_sort(int[] A, int p, int r) {

        if(count > K) return;   //종료조건

        if(p < r) {
            int q = Math.abs((p + r)/2);
            merge_sort(A, p, q);        //전반부 정렬
            merge_sort(A, q+1, r);   //후반부 정렬
            merge(A, p, q, r);          //병합
        }
    }

    static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int t = 0;

        while(i<=q && j<=r) {
            if(A[i] < A[j])
                tmp[t++] = A[i++];
            else 
                tmp[t++] = A[j++];
        }
        
        while (i <= q)          //왼쪽 배열 부분이 남은 경우
            tmp[t++] = A[i++];
        while (j <= r)           //오른쪽 배열이 남은 경우
            tmp[t++] = A[j++];
        i = p;
        t = 0;
        while (i <= r) {        //결과 A배열에 저장

            count++;

            if (count == K) {
                result = tmp[t];
                break;
            }
            A[i++] = tmp[t++];
        }


    }

    public static void main(String[] args) throws IOException{

        init();
        solution();
        System.out.println(sb);
    }
}
