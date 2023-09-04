import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, result;
	static char[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 80ms
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new char[N];

		input = br.readLine().toCharArray();

		result = Integer.MIN_VALUE;
		// 2번 인덱스의 숫자 (2번째 숫자)부터 괄호를 내 왼쪽에 칠건지(결국 안치는게 됨) 오른쪽에 칠건지 치지 않을건지
		solve(2, input[0] - '0');
		System.out.println(result);
	}

	private static void solve(int i, int sum) {
		
		if (i >= N) {
			result = Math.max(result, sum);
			return;
		}
		
		// 괄호 안 친 경우 지금까지의 합과 나를 계산한 결과를 다음 숫자 (index는 +2)에 넘긴다
		solve(i+2, cal(sum, input[i]-'0', input[i-1]));
		
		// 오른쪽에 괄호 친 경우
		if (i + 2< N) {
			// 옆 괄호 먼저 계산
			int right = cal(input[i]-'0', input[i+2]-'0' , input[i+1]);
			// 지금까지 결과와 합하기
			int left = cal(sum, right, input[i-1]);
			solve(i+4, left);
		}
	}

	private static int cal(int i, int j, char op) {
		if (op == '+')
			return i + j;
		else if (op == '-')
			return i - j;
		else
			return i * j;
	}
}