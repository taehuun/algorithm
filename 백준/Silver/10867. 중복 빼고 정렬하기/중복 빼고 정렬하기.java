import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] arr_copy = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		arr_copy[0] = arr[0];
		int count = 1;
		for(int i=1; i<n; i++) {
			if(arr[i] == arr[i-1])
				continue;
			else {
				arr_copy[count] = arr[i];
				count++;
			}
		}
		for(int i=0; i<count; i++)
			System.out.print(arr_copy[i] + " ");
		System.out.println();
	}

}