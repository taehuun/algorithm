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
        /*
        모든 경우의수를 다 찾는거라서 1부터 계산하는방법으로
         */
        int num = 1;

        while(num <= N){

            if(check(num)) {
                sb.append(num);
                return;
            }
            num++;
        }
        sb.append(0);
    }

    static boolean check(int num) {
        int sum = num;
        int temp = num;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum == N;
    }

    public static void main(String[] args) throws IOException{
        init();
        solution();
        System.out.println(sb);
    }
}
