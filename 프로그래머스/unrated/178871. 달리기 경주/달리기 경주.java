import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;

        // 해쉬맵에
        HashMap<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            playerIndexMap.put(players[i], i);
        }

        // 자리바꾸기
        for (String calling : callings) {
            int calledPlayerIndex = playerIndexMap.get(calling);
            int overtakenPlayerIndex = calledPlayerIndex - 1;

            String temp = players[overtakenPlayerIndex];
            players[overtakenPlayerIndex] = players[calledPlayerIndex];
            players[calledPlayerIndex] = temp;

            // 바꾼거 다시 해쉬맵에
            playerIndexMap.put(calling, overtakenPlayerIndex);
            playerIndexMap.put(temp, calledPlayerIndex);
        }

        return players;
    }
}