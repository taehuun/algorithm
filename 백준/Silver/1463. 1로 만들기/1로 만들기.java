import java.util.*;
import java.io.*;

public class Main {
	/*
	 * 점프 순간이동 살짝 다름
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int x;
	static boolean visit[];

	static void init() throws IOException {
		x = Integer.parseInt(br.readLine());
		visit = new boolean[1000000];
	}

	static int solve() {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(x);
		while(true) {
			ArrayList<Integer> newlist = new ArrayList<>();
			for (int x : list) {
				if(x == 1) return count;
//				if(visit[x]) continue;
//				visit[x] = true;
				
				if(x%3 == 0) newlist.add(x/3);
				if(x%2 == 0) newlist.add(x/2);
				if(x>0) newlist.add(x-1);
			}
			count++;
			list = newlist;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(solve());
	}

}