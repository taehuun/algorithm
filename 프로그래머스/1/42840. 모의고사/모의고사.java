import java.io.*;
import java.util.*;
class Solution {
    public ArrayList solution(int[] answers) {
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int len1 = 5;
        int len2 = 8;
        int len3 = 10;
        int[] count = new int[3];
        int len_ans = answers.length;
        
        for(int i=0; i<len_ans; i++){
            if(answers[i] == num1[i%len1]){
                count[0]++;
            }if(answers[i] == num2[i%len2]){
                count[1]++;
            }if(answers[i] == num3[i%len3]){
                count[2]++;
            }
        }
        int max = 0;
        for(int i=0; i<3; i++){
            if(max < count[i]){
                max = count[i];
            }
        }
        ArrayList<Integer> an = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max == count[i]){
                an.add(i+1);
            }
        }
        return an;
    }
}