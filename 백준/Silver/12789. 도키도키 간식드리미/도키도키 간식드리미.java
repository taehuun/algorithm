import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> que;
    static Stack<Integer> stack;
    static int N;

    static void init () throws IOException {

        N = Integer.parseInt(br.readLine());

        que = new ArrayDeque<>();
        stack = new Stack<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            que.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solution() {

        int num = 1;
        while (!que.isEmpty()) {
            int a = que.poll();

            if (a == num) {
                num++;
            } else {
                stack.push(a);
            }

            // 스택 확인
            while (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                num++;
            }
        }

        if (stack.isEmpty()) {
            sb.append("Nice");
        } else {
            sb.append("Sad");
        }
    }

    public static void main(String[] args) throws IOException {

        init();
        solution();
        System.out.println(sb);
    }
}
