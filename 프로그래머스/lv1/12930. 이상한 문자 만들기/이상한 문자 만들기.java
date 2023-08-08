class Solution {
    public String solution(String s) {
        String answer = "";
        
        for (int i = 0,count = 0; i < s.length(); i++) {
        	if(s.charAt(i)==' '){
        		answer += " ";
        		count = 0;
        		continue;
        	}
			if(count%2 == 0) {
				answer += s.toUpperCase().charAt(i);
				count++;
			}
			else {
				answer +=s.toLowerCase().charAt(i);
				count++;
			}
		}
        return answer;
    }
}