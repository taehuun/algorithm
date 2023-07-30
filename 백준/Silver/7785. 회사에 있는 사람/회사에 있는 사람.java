import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		HashMap<String, Boolean> code = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String[] log = br.readLine().split(" ");
			String name = log[0];
			String action = log[1];
			//출근이면 true, 퇴근이면 flase
			code.put(name, action.equals("enter"));
		}
		List<String> enter_name = new ArrayList<>();
		for (String name : code.keySet()) {
			if(code.get(name)) {
				enter_name.add(name);
			}
		}
		Collections.sort(enter_name, Collections.reverseOrder());
		for (String str : enter_name) {
			System.out.println(str);
		}
	}

}