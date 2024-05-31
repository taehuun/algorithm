import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        //해쉬맵으로 정렬해놓고 갯수 곱으로
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            
            //만약에 이미 들어가있으면 추가
            if(map.containsKey(key)){
                int val = map.get(key)+1;
                map.replace(key, val);
            }else{
                map.put(key, 1);
            }
        }
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);   // 조합 -> 안입는 경우도 고려하기 위해 + 1
        }
        
        answer -= 1; // 모두 '안입음'일 경우 -1 해주기 
        
        return answer;
    }
}