import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int a, b, c, t;
	//a = 5분, b = 1분, c = 10초
	
	//========t초 입력받기===
	static void init() throws IOException{
		t = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		//10으로 나눈 나머지가 0이 아니면 a, b버튼도 10초의 배수기 때문에 나누어 떨어지지 않는다
		if(t%10!=0) {		
			System.out.println(-1);
			return;
		}
		//분을 초로 바꿔서 각각 저장한다.
		a = t/300;
		t %= 300;
		b = t/60;
		t %= 60;
		c = t/10;
		System.out.println(a + " " + b + " " + c);
	}
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
	}

}