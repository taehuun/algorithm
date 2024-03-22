import java.io.*;
import java.util.*;

class Solution {
    
    /*for문 돌리면서 나누어 떨어지면 나눈 값이랑 몫이랑 저장, 근데 절반만 확인하면됨
    해서 만약에 2, 3 나오면 4, 5로 하고 (5 *2 + 2*2)
    */

    
    public ArrayList solution(int brown, int yellow) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=yellow; i++){
            /* ye_i = 4 ye_re = 6
                bro_i = 6 bro_re = 8
            */
            
            if(yellow % i == 0){
                int ye_i = i;
                int ye_re = yellow / i;
                int bro_i = i+2;
                int bro_re = (yellow / i)+2;
                list.add(bro_re);
                list.add(bro_i);
                if((bro_i*2) + (ye_re*2) == brown){
                    list = new ArrayList<>();
                    list.add(bro_re);
                    list.add(bro_i);
                    break;
                }
            }
        }
        return list;
    }
}