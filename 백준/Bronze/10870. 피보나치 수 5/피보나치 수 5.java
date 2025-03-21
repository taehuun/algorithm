import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    static void init() throws IOException {

        n = Integer.parseInt(br.readLine());
    }

    static void solution() {
        sb.append(go(n));
    }

    static int go(int num) {

        if(num == 0)
            return 0;
        else if(num <= 2)
            return 1;
        return go(num-1) + go(num-2);
    }

    public static void main(String[] args) throws IOException {

        init();
        solution();
        System.out.println(sb);
    }
}
