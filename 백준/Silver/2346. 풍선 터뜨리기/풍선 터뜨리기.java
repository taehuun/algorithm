import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

        static class Balloon {
        int index; // 풍선 번호
        int numValue; // 이동 값

        public Balloon(int index, int numValue) {
            this.index = index;
            this.numValue = numValue;
        }
    }
    
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static Deque<Balloon> queue = new ArrayDeque<>();
    static int N; // 풍선의 개수
    static int[] balloonLocation;

    // 입력 초기화 메서드
    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        balloonLocation = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            balloonLocation[i] = Integer.parseInt(st.nextToken());
        }
    }

    // 풍선 처리 메서드
    static void solution() {
        sb.append("1 "); // 첫 번째 풍선은 항상 먼저 터트림
        int moveValue = balloonLocation[0]; // 첫 번째 풍선의 이동 값

        // 첫 번째 풍선 이후의 풍선을 큐에 추가
        for (int i = 1; i < N; i++) {
            queue.add(new Balloon(i + 1, balloonLocation[i]));
        }

        // 큐가 빌 때까지 풍선을 터트림
        while (!queue.isEmpty()) {
            if (moveValue > 0) {
                // 이동 값이 양수: 큐의 앞쪽으로 이동
                for (int i = 1; i < moveValue; i++) {
                    queue.add(queue.poll());
                }
                Balloon next = queue.poll(); // 다음 풍선 터트림
                moveValue = next.numValue;
                sb.append(next.index).append(" ");
            } else {
                // 이동 값이 음수: 큐의 뒤쪽으로 이동
                for (int i = 1; i < -moveValue; i++) {
                    queue.addFirst(queue.pollLast());
                }
                Balloon next = queue.pollLast(); // 다음 풍선 터트림
                moveValue = next.numValue;
                sb.append(next.index).append(" ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
