import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set;
    static int N;

    static void init() throws IOException {
        set = new HashSet<>();
        set.add("ChongChong");
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            String input1 = st.nextToken();
            String input2 = st.nextToken();

            if(set.contains(input1) || set.contains(input2)) {
                set.add(input1);
                set.add(input2);
            }
        }

        sb.append(set.size());

    }

    public static void main(String[] args) throws IOException {

        init();
        System.out.println(sb);

    }
}
