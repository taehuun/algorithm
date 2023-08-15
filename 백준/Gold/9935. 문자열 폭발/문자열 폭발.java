import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String str, boom;
	static int n, m, index;
	static char[] arr;
	static boolean flag;
	
	private static void init() throws IOException{
		str = br.readLine();
		boom = br.readLine();
		n = str.length();
		m = boom.length();
		arr = new char[n];
	}
	
	private static void solve() {
		for (int i = 0; i < n; i++) {
			arr[index++] = str.charAt(i);
			if(index>=m && arr[index-1]==boom.charAt(m-1)) {
				flag = true;
				for (int j = 2; j <= m; j++) {
					if(arr[index-j] != boom.charAt(m-j)) {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				index -= m;
			}
			flag = false;
		}
	}
	
	private static void print() {
		
		if(index == 0) {
			sb.append("FRULA\n");
		}
		else {
			for (int i = 0; i < index; i++) {
				sb.append(arr[i]);
			}
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		print();
	}

}