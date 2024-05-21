import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set list = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        System.out.println(list);
        if(list.size() <= nums.length/2){
            return list.size();
        }else{
            return nums.length/2;
        }
        
    }
}