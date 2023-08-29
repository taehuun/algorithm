import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] s;
	static StringBuilder sb = new StringBuilder();
	static int arr[], n = 26;
	static boolean visit[];
	
	static void init() throws IOException{
		s = br.readLine().toCharArray();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = -1;
		}
		visit = new boolean[n];
	}
	
	static void solve() {
		for (int i = 0; i < s.length; i++) {
			int a = s[i] - 'a';
			if(!visit[a]) {				
				arr[a] = i;
				visit[a] = true;
			}
		}
	}
	
	static void print() {
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		print();
	}

}