import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static int N, arr[]; // N (1 ≤ N ≤ 1,000), arr가 주어진다. (1 ≤ arr ≤ 1,000)
	static int list[];

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		list = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		int j = 0;
		list[0] = arr[0];
		for (int i = 1; i < N; i++) {
			if(list[j]<arr[i]) {
				list[++j] = arr[i];
			}
			else {
				int idx = binarysearch(0, j, arr[i]);
				list[idx] = arr[i];
			}
		}
		return j+1;
	}

	static int binarysearch(int start, int end, int target) {
		int mid;
		while (start < end) {
			mid = (start+end)/2;
			if(list[mid] < target) {
				start = mid + 1;
			}
			else end = mid;
		}
		return end;
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(solve());
	}

}