import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder   sb = new StringBuilder();
    static Queue<Integer> que;
    static int N, K;

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        que = new ArrayDeque<>();

        for(int i=1; i<=N; i++) {
            que.offer(i);
        }
    }

    static void solution() {
        sb.append("<");

        while(que.size() > 1){

            for(int i=0; i<K-1; i++){
                que.offer(que.poll());
            }

            sb.append(que.poll()).append(", ");
        }
        sb.append(que.poll());
        sb.append(">");
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
