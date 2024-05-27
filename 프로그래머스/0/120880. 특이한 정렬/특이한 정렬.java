import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] numArray = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff1 = Math.abs(o1 - n);
                int diff2 = Math.abs(o2 - n);
                if (diff1 == diff2) {
                    return o2 - o1;
                }
                return diff1 - diff2;
            }
        });
        
        return Arrays.stream(numArray).mapToInt(Integer::intValue).toArray();
    }
}
