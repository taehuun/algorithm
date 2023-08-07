import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int s_len = s.length();
		String[] s_sort = new String[s_len];
		for (int i = 0; i < s_len; i++) {
			s_sort[i] = s.substring(i);
		}
		Arrays.sort(s_sort);
		for (int i = 0; i < s_len; i++) {
			System.out.println(s_sort[i]);
		}
	}

}