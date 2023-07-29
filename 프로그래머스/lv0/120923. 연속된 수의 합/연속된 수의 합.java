class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int value = (total - num * (num - 1) / 2) / num;

        for (int i = 0; i < num; i++) {
            answer[i] = value + i;
        }

        return answer;
    }
}
