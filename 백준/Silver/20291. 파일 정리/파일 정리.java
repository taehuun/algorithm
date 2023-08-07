import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String fileName = br.readLine();
			int dot = fileName.indexOf(".");
			String extension = fileName.substring(dot + 1);
			map.put(extension, map.getOrDefault(extension, 0) + 1);
		}
		
		for (Map.Entry<String, Integer> str : map.entrySet()) {
			System.out.println(str.getKey() + " " + str.getValue());
		}
	}
}