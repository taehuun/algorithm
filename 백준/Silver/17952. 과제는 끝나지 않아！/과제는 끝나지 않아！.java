import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int n, commend, a, t, sum, work[];
	static Stack<int[]> stack;

	static void init() throws IOException {
		//n = 업무량
		n = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		sum = 0;
		for (int i = 0; i < n; i++) {
			//업무를 일단 한줄로 입력받고 입력받은걸 input[]배열에 쪼개서 넣음
			String in = br.readLine();
			String[] input = in.split(" ");
			
			if (input.length > 1) {
				// 입력받은 input을 int형으로 바꿈
				commend = Integer.parseInt(input[0]);
				a = Integer.parseInt(input[1]);
				t = Integer.parseInt(input[2]);
				//배열에 담음
				work = new int[2];		//배열에 매번 다른 값이 담기니까 매번 초기화
				work[0] = a;
				work[1] = t;
				work[1]--;		//업무를 받자마자 한다고 했으니까 받으면 1뺀다
				if (work[1] == 0) {		//만약에 바로 처리되면
					sum += work[0];		//스택에 안넣고 바로 점수 추가하고 끝
				} 
				else {
					stack.push(work);		//바로 처리 안되면 스택에 넣음
				}
			} 
			else {			//만약에 0이 입력되면
				if (!stack.isEmpty()) {	//스택이 비어있지 않으면
					work = stack.pop();
					work[1]--;		//업무 처리하고
					if (work[1] == 0) {		//다 처리되면
						sum += work[0];		//점수 받음
					} else {
						stack.push(work);	//아니면 다시 스택에 넣어둠
					}
				}
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		init();
	}

}