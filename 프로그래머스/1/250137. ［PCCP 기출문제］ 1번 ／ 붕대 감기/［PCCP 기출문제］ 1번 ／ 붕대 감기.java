import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = attacks[attacks.length-1][0];
        int index = 0;
        int conti = 0;
        int max = health;
        for(int i=0; i<=time; i++){
            //공격 받았을때랑 안받았을때로 구분하자
            if(attacks[index][0] == i){
                conti = 0;
                health -= attacks[index][1];
                index++;
                if(health <= 0) break;
            }else{
                conti++;
                health += bandage[1];
                if(conti == bandage[0]){
                    health += bandage[2];
                    conti = 0;
                }
                if(health > max){
                        health = max;
                }
            }
        }
        if(health<=0) return -1;
        else return health;
    }
}