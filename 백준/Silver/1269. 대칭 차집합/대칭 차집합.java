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
    static int A, B;
    static Set<Integer> setA, setB;

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        setA = new HashSet<>();
        setB = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<A; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<B; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solution() {

        int ans = 0;

        for(int num : setA){
            if(!setB.contains(num)) ans++;
        }
        for(int num : setB){
            if(!setA.contains(num)) ans++;
        }
        sb.append(ans);
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }
}
