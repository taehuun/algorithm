import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] stackType, stackValues, queueValues;

    // 입력 초기화
    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        stackType = new int[N];
        stackValues = new int[N];

        // 스택 타입 입력 (0: 큐 동작, 1: 스택 동작)
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            stackType[i] = Integer.parseInt(st.nextToken());
        }

        // 스택 초기 값 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            stackValues[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        queueValues = new int[M];

        // 큐에 추가할 값 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            queueValues[i] = Integer.parseInt(st.nextToken());
        }
    }

    // 문제 해결
    static void solution() {
        Deque<Integer> deque = new ArrayDeque<>();

        // stackType이 0인 경우만 deque에 초기 값 추가
        for (int i = 0; i < N; i++) {
            if (stackType[i] == 0) {
                deque.addLast(stackValues[i]);
            }
        }

        // M개의 값을 큐의 앞에 삽입하고 뒤에 값을 꺼내 순서대로 처리
        for (int i = 0; i < M; i++) {
            deque.addFirst(queueValues[i]); // 큐의 맨 앞에 추가
            sb.append(deque.pollLast()).append(" "); // 큐의 맨 뒤 값을 출력
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
