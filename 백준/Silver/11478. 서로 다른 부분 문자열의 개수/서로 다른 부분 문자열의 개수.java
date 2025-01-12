import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String S;
    static Set<String> set;

    static void init() throws IOException {
        S = br.readLine();
        set = new HashSet<>();
    }

    static void solution() {

        for (int i=0; i<S.length(); i++) {
            for (int j=i+1; j<=S.length(); j++) {
                set.add(S.substring(i, j));
            }
        }
        sb.append(set.size());
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
