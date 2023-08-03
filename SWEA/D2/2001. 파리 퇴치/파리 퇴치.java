import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());					
				}
			}
			int max = 0;
			for (int j = 0; j <= n-m; j++) {
				for (int k = 0; k <= n-m; k++) {
					int sum=0;
					for(int a=j; a<m+j; a++) {
						for(int b=k; b<m+k; b++) {
							sum += map[a][b];
						}
					}
					if(sum>max)
						max = sum;
				}
			}
			arr[i] = max;
		}
		for(int i=0; i<t; i++) {
			System.out.printf("#%d %d\n",i+1,arr[i]);
		}
	}

}