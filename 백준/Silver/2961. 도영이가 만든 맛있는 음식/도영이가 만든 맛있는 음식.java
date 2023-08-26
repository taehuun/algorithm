import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int n, sin[], sson[], best;

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		sin = new int[n];
		sson = new int[n];
		best = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			sson[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void go(int idx, int size, int sin_sum, int sson_sum) {
		if (idx == n) {
			if (size != 0) {
				best = Math.min(best, Math.abs(sin_sum - sson_sum));
			}
			return;
		}
		go(idx + 1, size, sin_sum, sson_sum);
		go(idx + 1, size + 1, sin_sum * sin[idx], sson_sum + sson[idx]);
	}

	public static void main(String[] args) throws IOException {
		init();
		go(0, 0, 1, 0);
		System.out.println(best);
	}
}