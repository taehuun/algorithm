class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] count = new int[1002];
        int max = 0;
        
        for(int i=0; i<array.length; i++){
            count[array[i]]++;
            if(count[array[i]] > max){
                max = count[array[i]];
                answer = array[i];
            }
            else if(count[array[i]] == max)
                answer = -1;
        }
        
        return answer;
    }
}