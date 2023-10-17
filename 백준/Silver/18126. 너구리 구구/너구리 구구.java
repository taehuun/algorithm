import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int[][] home;
    static int N;
    static boolean[] visit;
    static long maxDistance = 0;
    
    static void init() throws IOException{
        N = Integer.parseInt(br.readLine());
        
        home = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            home[a][b] = c;
            home[b][a] = c;
        }
    }
    
    static void go(int v, long distance) {
        visit[v] = true;
        maxDistance = Math.max(maxDistance, distance);
        
        for (int i = 0; i < N; i++) {
            if (home[v][i] != 0 && !visit[i]) {
                go(i, distance + home[v][i]);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        visit[0] = true;
        go(0, 0);
        System.out.println(maxDistance);
    }
}