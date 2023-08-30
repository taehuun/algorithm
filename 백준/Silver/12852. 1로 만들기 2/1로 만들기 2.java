import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int x;
	static boolean visit[];

	static void init() throws IOException {
		x = Integer.parseInt(br.readLine());
	}

	static void solve() {
		if(x == 1) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		int count = 0;
		
		ArrayList<Integer>[] list = new ArrayList[1000001];
		for (int i = 0; i < 1000001; i++) {
			list[i] = new ArrayList<>();
		}
		list[count].add(x);
		while(true) {
			ArrayList<Integer> newlist = new ArrayList<>();
			for (int x : list[count]) {
				if(x == 1) {
					sb.append(count).append("\n");
					check(count, list);
					System.out.println(sb);
					return;
				}
				if(x%3 == 0) newlist.add(x/3);
				if(x%2 == 0) newlist.add(x/2);
				if(x>0) newlist.add(x-1);
			}
			count++;
			list[count] = newlist;
		}
	}
	
	static void check(int count, ArrayList<Integer>[] list) {
		Stack<Integer> stack = new Stack<>();
		int x_2 = 1;
		stack.push(x_2);
		for (int i = count-1; i > 0; i--) {
			for (int j : list[i]) {
				if(j == x_2*3) {
					stack.push(j);
					x_2 = j;
					break;
				}
				else if(j==x_2*2) {
					stack.push(j);
					x_2 = j;
					break;
				}
				else if(j == x_2+1) {
					stack.push(j);
					x_2 = j;
					break;
				}
			}
		}
		stack.push(x);
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		/*
		 * x = 1이되면 list[count] 부터 확인
		 * i는 1부터
		 * list[count]배열에 1에 *3해서 list[count-i]에 있는지 확인
		 * 없으면 *2해서 list[count-i]에 있는지 확인 없으면 +1해서
		 * 있으면 그거 stack에 담고 continue; count = 0이 될때까지
		 */
	}
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
		System.out.println();
	}


}