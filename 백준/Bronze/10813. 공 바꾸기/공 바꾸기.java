import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	static int n, m, arr[];
	
	static void init() throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}
	
	static void print() {
		for(int i=1; i<n+1; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) throws IOException{
		init();
		print();
	}

}