import java.util.ArrayDeque;
class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0, sum2 = 0;
        ArrayDeque<Integer> que1 = new ArrayDeque<>();
        ArrayDeque<Integer> que2 = new ArrayDeque<>();
        for (int i = 0; i < queue1.length; i++) {
			sum1 += queue1[i];
			que1.offer(queue1[i]);
		}
        for (int i = 0; i < queue2.length; i++) {
			sum2 += queue2[i];
			que2.offer(queue2[i]);
		}
        if((sum1+sum2)%2 != 0) return -1;
        while((sum1+sum2)/2 != sum1) {
        	if(sum1 > sum2) {
        		int a = que1.poll();
        		sum1 -= a;
        		sum2 += a;
        		que2.offer(a);
        	}
        	else {
        		int a = que2.poll();
        		sum1 += a;
        		sum2 -= a;
        		que1.offer(a);
        	}
        	answer++;
        	if(que1.isEmpty() || que2.isEmpty() || answer>queue1.length*4) return -1;	//현영이랑 민석이 코드 참고했음
        }
        return answer;
    }
}