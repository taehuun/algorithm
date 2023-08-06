import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
//		List<Student> list = new ArrayList<>();			객체 만들어서 할까 하다가 2차원 배열로했음(배열이 정렬은 가장 빠르다고 했음)
		String[][] students = new String[n][4];
		//===================입력===============
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<4; j++) {
				students[i][j] = st.nextToken();
			}
		}
		//===============정렬================
		Arrays.sort(students, (o1, o2) -> {
			int res = Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
			if(res==0) {
				res = Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);
				if(res == 0) {
					res = Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
					if(res == 0) {
						res = o1[0].compareTo(o2[0]);
						return res;
					}
					return res;
				}
				return res;
			}
			return res;
		});
		//==============출력======================
		for (int i = 0; i < n; i++) {
			sb.append(students[i][0]).append("\n");
		}
		System.out.println(sb);
	}

}