import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] command = str.split(" ");
			if(command[0].equals("push")) {
				stack.push(Integer.parseInt(command[1]));
			}
			else if(command[0].equals("pop")) {
				if(!stack.isEmpty()) {
					System.out.println(stack.pop());
				}
				else {
					System.out.println("-1");
				}
			}
			else if(command[0].equals("size")) {
				System.out.println(stack.size());
			}
			else if(command[0].equals("empty")) {
				if(stack.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			}
			else if(command[0].equals("top")) {
				if(stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.peek());
			}
		}
		
	}

}