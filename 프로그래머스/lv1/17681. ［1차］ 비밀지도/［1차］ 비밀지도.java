class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "";
			for(int j= n-1; j>=0; j--) {
				if((arr1[i]>>j&1) == 1 || (arr2[i]>>j&1) == 1) {
					answer[i] += "#";
				}
				else {
					answer[i] += " ";
				}
			}
		}
        return answer;
    }
}