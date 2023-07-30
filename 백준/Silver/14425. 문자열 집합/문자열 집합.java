import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> sets = new HashSet<>();
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			sets.add(str);
		}
		int count = 0;
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			if(sets.contains(str))	//질문해야됨 왜 equals가 아니지
				count++;
			
		}
		System.out.println(count);
	}

}