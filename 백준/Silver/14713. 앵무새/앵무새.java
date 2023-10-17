import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Queue<String>[] que;
    static Queue<String> answer;

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        que = new ArrayDeque[N];
        answer = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            que[i] = new ArrayDeque<>();
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                que[i].offer(in[j]);
            }
        }
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < in.length; i++) {
            answer.offer(in[i]);
        }
    }

    static void solve() {
        while (!answer.isEmpty()) {
            boolean found = false;

            for (int i = 0; i < que.length; i++) {
                if (!que[i].isEmpty()) {
                    String a = que[i].poll();
                    if (a.equals(answer.peek())) {
                        answer.poll();
                        found = true;
                    } else {
                        ((ArrayDeque) que[i]).offerFirst(a);
                    }
                }
            }

            if (!found) {
                System.out.println("Impossible");
                return;
            }
        }
        
        for (Queue<String> q : que) {
			if(!q.isEmpty()) {
				System.out.println("Impossible");
				return;
			}
		}
        
        System.out.println("Possible");
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

}