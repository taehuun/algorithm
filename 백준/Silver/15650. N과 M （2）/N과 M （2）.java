import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static int[] numbers;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];
		combi(0, 1);
	}
	private static void combi(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == m) {
			for (int i = 0; i <m; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= n; i++) {
			numbers[cnt] = i;
			combi(cnt+1, i+1);
		}
	}

}