class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        
        for (int num = 1; cnt < n; num++) {
            if (num % 3 == 0 || String.valueOf(num).contains("3")) {
                continue;
            }
            cnt++;
            answer = num;
        }
        return answer;
    }
}