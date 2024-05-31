import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        //맵으로 하나 선언해.
        //key값으로 name string이고 값이 int yearning
        //2중 for문돌면서 안에 for문으로 만약에 key랑 일치하면 sum에 더하기하면끝
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                if(map.containsKey(photo[i][j])){
                    sum += map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}