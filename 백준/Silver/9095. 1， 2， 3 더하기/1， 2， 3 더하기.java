import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int dp[];
    static void init() throws IOException{

        n = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;  //dp 초기값
        dp[2] = 2;
        dp[3] = 4;
        for (int i=4; i<11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        for (int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
