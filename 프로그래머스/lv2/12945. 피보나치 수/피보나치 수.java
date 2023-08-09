class Solution {
    public int solution(int n) {
		int[] answer = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i == 0) answer[i] = 0;
			else if (i == 1) answer[i] = 1;
			else {
                answer[i] = (answer[i-2] + answer[i-1])%1234567;
			}
		}
		return answer[n];
	}
    
    
    
    
	// public int fib(int n) {
	// 	if(n==0) return 0;
	// 	else if(n==1) return 1;
	// 	else return (fib(n-1) + fib(n-2))% 1234567;
	// }
	// public int solution(int n) {
	// int answer = fib(n);
	// return answer;
	// }
}