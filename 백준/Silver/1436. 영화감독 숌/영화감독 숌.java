import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int N;

    static void init() throws IOException {

        N = Integer.parseInt(br.readLine());

    }

    static void solution() {

        int num = 666;
        int count = 1;

        while (count < N) {
            num++;

            if(String.valueOf(num).contains("666"))
                count++;
        }

        sb.append(num);
    }

    public static void main(String[] args) throws IOException {

        init();
        solution();
        System.out.println(sb);

    }
}
