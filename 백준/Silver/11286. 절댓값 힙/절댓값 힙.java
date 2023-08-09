import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)>Math.abs(o2))
					return 1;
				else if(Math.abs(o1)<Math.abs(o2))
					return -1;
				else {
					if(o1>o2)
						return 1;
					else
						return -1;
				}
				
			}
			
		});
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x!=0) {
				pq.add(x);
			}
			else if(x==0 && !(pq.isEmpty())){
				sb.append(pq.remove()).append("\n");
			}
			else if(x==0 && pq.isEmpty()){
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}
