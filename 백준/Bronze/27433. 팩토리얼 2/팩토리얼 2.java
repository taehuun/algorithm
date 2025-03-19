import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        System.out.println(go(N));
    }

    static long go(int n) {

        if(n <= 0) return 1;

        return n * go(n-1);
    }

    public static void main(String[] args) throws IOException {

        init();

    }
}
