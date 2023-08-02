class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder(my_string);
        char target = letter.charAt(0);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == target) {
                sb.deleteCharAt(i);
                i--; // 인덱스를 하나 감소시켜 다음 글자를 건너뛰지 않도록
            }
        }
        return sb.toString();
    }
}