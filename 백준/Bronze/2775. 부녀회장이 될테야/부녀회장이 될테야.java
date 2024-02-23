import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int k, n, dp[][];

    static void setting(){

        dp = new int[15][15];
        for (int i=1; i<15; i++){
            dp[0][i] = i;
        }

        for (int i=1; i<15; i++){
            for (int j=1; j<15; j++){
                for (int k=1; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

//        for (int i=2; i>=0; i--){
//            for (int j=1; j<=3; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    static void init() throws IOException{

        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        sb.append(dp[k][n]).append("\n");
    }

    public static void main(String[] args) throws IOException{

        int T = Integer.parseInt(br.readLine());
        setting();
        for (int i=0; i<T; i++){
            init();
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
