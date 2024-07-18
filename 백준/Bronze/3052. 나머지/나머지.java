import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int[] count;
    static int ans;
    static void init() throws IOException{
        count = new int[42];
        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            int a = num%42;
            count[a]++;
        }

    }

    static void solve() {
        ans = 0;
        for (int i=0; i<42; i++){
            if(count[i] > 0){
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
}