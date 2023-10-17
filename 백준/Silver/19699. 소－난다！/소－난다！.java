import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, cow[];
	static boolean[] visit;
	static Set<Integer> set;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cow = new int[N];
		visit = new boolean[N];
		set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cow[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		goSum(0, 0, 0);

		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		if (set.size() == 0) {
			sb.append(-1);
		}
		else {
			for (int i : list) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	static void goSum(int idx, int start, int sum) {
		if (idx == M) {
			if (prime(sum)) {
				set.add(sum);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				goSum(idx + 1, i + 1, sum + cow[i]);
				visit[i] = false;
			}
		}
	}

	static boolean prime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		init();
		solve();
	}

}