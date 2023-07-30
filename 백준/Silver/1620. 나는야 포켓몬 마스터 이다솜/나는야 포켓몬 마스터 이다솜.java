import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> code_name = new HashMap<>();
		HashMap<Integer, String> code_int = new HashMap<>();
		for(int i=0; i<n; i++) {
			String name = br.readLine();
			code_name.put(name, i+1);
			code_int.put(i+1, name);
		}
		List<String> result = new ArrayList<>();
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			if(Character.isDigit(str.charAt(0))) {
				int number = Integer.parseInt(str);
				result.add(code_int.get(number));
			}
			else
				result.add(code_name.get(str).toString());
		}
		for (String str : result) {
			System.out.println(str);
		}
	}

}