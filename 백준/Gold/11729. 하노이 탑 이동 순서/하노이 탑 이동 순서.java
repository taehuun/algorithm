import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

    }

    static void solution() {
        //횟수
        sb.append((int)Math.pow(2, N) - 1).append("\n");
        //수행
        go(N, 1, 2, 3);
    }

    static void go(int n, int num1, int num2, int num3) {

        if(n == 1){
            sb.append(num1 + " " + num3).append("\n");
            return;
        }

        //1번에서 2번으로
        go(n-1, num1, num3, num2);
        //출력
        sb.append(num1 + " " + num3).append("\n");
        //2번에서 3번으로
        go(n-1, num2, num1, num3);
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
