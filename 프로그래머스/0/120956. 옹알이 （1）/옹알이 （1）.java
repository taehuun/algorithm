class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] strs = {"aya", "ye", "woo", "ma"};
        
        for(String a : babbling){
            for(String str : strs){
                a = a.replace(str, " ");
            }
            if(a.replaceAll(" ", "").equals(""))
                answer++;
        }
        
        return answer;
    }
}