import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, count1, count2;
    static int[] f;

    static void init() throws IOException {

        n = Integer.parseInt(br.readLine());
        f = new int[n];
    }

    static void solution() {
        count1 = 0;
        count2 = 0;
        sb.append(go(n)).append(" ").append(go2(n));
    }

    static int go(int num) {

        if(num == 0)
            return 0;
        else if(num <= 2){
            count1++;
            return 1;
        }
        return go(num-1) + go(num-2);
    }

    static int go2(int num) {

        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<num; i++) {
            f[i] = f[i-1] + f[i-2];
            count2++;
        }

        return count2;

    }

    public static void main(String[] args) throws IOException {

        init();
        solution();
        System.out.println(sb);
    }
}
