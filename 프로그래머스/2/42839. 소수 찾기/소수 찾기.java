import java.io.*;
import java.util.*;
class Solution {
    /**
    일단 문자열 나눈 다음에 arr에 넣어두고 조합 돌려서 생성한다음에
    소수인지 체크
    **/
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visit =  new boolean[7];
    public int solution(String numbers){
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++){
            sub(numbers,"", i+1);
        }
        for(int num : set){
            if(prime(num)){
                answer++;
            }
        }
        return answer;
    }
    //조합
    static void sub(String str, String temp, int N){
        //종료조건
        if(temp.length() == N){
            int num = Integer.parseInt(temp);
                set.add(num);
            return;
        }
        for(int i=0; i<str.length(); i++){
            if(visit[i]) continue;
            visit[i] = true;
            temp += str.charAt(i);
            sub(str, temp, N);
            visit[i] = false;
            temp = temp.substring(0, temp.length()-1);
        }
    }
	//소수 판단
	static boolean prime(int n) {
		if(n<2) return false;
		
		for(int i=2; i*i<=n; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
}