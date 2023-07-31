import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][3];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = String.valueOf(i);
		}
		Arrays.sort(arr, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0])) {
					return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);
				}
				else
					return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
		});
		for (String[] strings : arr) {
			System.out.println(strings[0] + " " + strings[1]);
		}
	}

}