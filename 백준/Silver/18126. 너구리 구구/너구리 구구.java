import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int[][] home;
    static int N;
    static long max;
    static boolean[] visit;
    
    static void init() throws IOException{
    	N = Integer.parseInt(br.readLine());
    	
    	home = new int[N][N];
    	visit = new boolean[N];
    	max = 0;
    	for (int i = 0; i < N-1; i++) {
    		st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			home[a][b] = c;
			home[b][a] = c;
		}
    }
    
    static void go(int v, long val) {
    	max = Math.max(max, val);
    	
    	 for (int i = 0; i < N; i++) {
             if (home[v][i] != 0 && !visit[i]) {
            	 visit[i] = true;
                 go(i, val + home[v][i]);
             }
         }
    }

	public static void main(String[] args) throws IOException{
		init();
		visit[0] = true;
		go(0, 0);
		System.out.println(max);
	}

}