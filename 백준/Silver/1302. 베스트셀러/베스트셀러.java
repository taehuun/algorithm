import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> str = new HashMap<>();
		int max = 0;
		for(int i=0; i<n; i++) {
			String title = br.readLine();
			 str.put(title, str.getOrDefault(title, 0) + 1);
			 max = Math.max(max, str.get(title));
		}
		List<String> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : str.entrySet()) {
			if(entry.getValue() == max)
				list.add(entry.getKey());
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}

}