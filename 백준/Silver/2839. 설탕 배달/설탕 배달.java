import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int value = 1;
	static int count = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
//		for (int i = 0; i < 4; i++) {
			if(n>4) {
				if(n==7) {
					System.out.println(count);
					return;
				}
				count = n/5;
				n = n%5;
				if(n==0) {
					System.out.println(count);
					return;
				}
				else if((n==1||n==4) && count>0) {
					n = n+5;
					count--;
					n = n/3;
					count += n;
				}
				else if(n==2 && count>1) {
					n = n+10;
					count -= 2;
					n /= 3;
					count += n;
				}
				else if(n==3) {
					n /= 3;
					count += n;
				}
			}
			else {
				if(n%3==0) {
					count = n/3;
					n = n%3;
				}
			}
			//n이 4보다 크다면 위쪽 연산 작으면 아래쪽으로
//		}
		System.out.println(count);
	}
}