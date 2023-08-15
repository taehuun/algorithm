import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int n, count;
	
	private static void init() throws IOException{
		n = Integer.parseInt(br.readLine());
	}
	
	private static void go(int depth) {
		//만약에 조건이 다 만족하고 퀸 갯수가 n개랑 같으면
		if(depth == n) {
			count++;
			return;
		}
		for (int y = 0; y < n; y++) {
			arr[depth] = y;
			if(possible(depth)) {
				go(depth+1);
			}
		}
	}
	
	private static boolean possible(int x) {
		for (int i = 0; i < x; i++) {
			//같은 줄에 퀸이 이미 있으면 컷
			if(arr[x] == arr[i]) {	//arr[x]행의 값이 열인데 있으니까
				return false;
			}
			//대각선도 검사해야됨
			else if(Math.abs(x - i) == Math.abs(arr[x] - arr[i])) {
				return false;
			}
		}
		//for문 돌면서 다 검사했는데 안걸리면 없는거니까 return true
		return true;
	}
	
	private static void print() {
		System.out.println(count);
	}
	public static void main(String[] args) throws IOException {
		init();
		arr = new int[n];
		go(0);
		print();
	}

}