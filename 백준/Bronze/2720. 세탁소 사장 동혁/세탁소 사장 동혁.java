import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, C;
	static int quarter, dime, nickel, penny;
	
	static void init() throws IOException{
		C = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		quarter = C/25;
		C %= 25;
		dime = C/10;
		C %= 10;
		nickel = C/5;
		penny = C%5;
		sb.append(quarter).append(" ")
		.append(dime).append(" ")
		.append(nickel).append(" ")
		.append(penny).append(" ").append("\n");
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			init();
			solve();
		}
		System.out.println(sb);
	}

}