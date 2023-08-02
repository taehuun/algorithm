public class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int p_length = p.length();
        for (int i = 0; i < t.length() - p_length + 1; i++) {
            String str = t.substring(i, i + p_length);
            if (str.compareTo(p) <= 0)
                answer++;
        }
        return answer;
    }
}

