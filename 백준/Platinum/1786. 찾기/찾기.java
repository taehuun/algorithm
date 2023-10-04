import java.util.*;
import java.io.*;
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] pi = new int[n];
		int idx = 0;
		for (int i = 1; i < n; i++) {
			
			while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = pi[idx-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx++;
				pi[i] = idx;
			}
		}
		
		return pi;
	}
	
	static void KMP(String parent, String pattern) {
        int[] pi = makeTable(pattern);
        int n1 = parent.length();
        int n2 = pattern.length();
        int idx = 0;
        
        List<Integer> list = new ArrayList<>(); // To store the starting positions of the matched patterns

        for (int i = 0; i < n1; i++) {
            while(idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = pi[idx-1];
            }
            
            if(parent.charAt(i) == pattern.charAt(idx)) {
                if(idx == n2-1) {
                    list.add((i - n2 + 1) + 1);
                    idx = pi[idx]; 
                } else {
                    idx += 1;
                }
            }
        }

        sb.append(list.size()).append("\n");

        for(int pos : list)
            sb.append(pos).append(" ");
    }

    public static void main(String[] args) throws IOException{
       String T = br.readLine();
       String P = br.readLine();

       KMP(T, P);

       System.out.println(sb); 
   }
}