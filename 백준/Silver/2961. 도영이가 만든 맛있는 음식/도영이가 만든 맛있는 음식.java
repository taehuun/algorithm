import java.util.*;
import java.io.*;
public class Main {

	static int n;
	static int[] sin = new int[11];
	static int[] sson = new int[11];
	static int best = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			sson[i] = Integer.parseInt(st.nextToken());
			
		}
		powerSet(0, 0, 1, 0);
		System.out.println(best);
	}
	private static void powerSet(int idx, int size, int sin_sum, int sson_sum) {
		// TODO Auto-generated method stub
		if(idx == n) {
			if(size != 0) {
				best = Math.min(best, Math.abs(sin_sum - sson_sum));
			}
			return;
		}
		powerSet(idx+1, size, sin_sum, sson_sum);
		powerSet(idx+1, size+1, sin_sum*sin[idx], sson_sum+sson[idx]);
	}
	
	

}