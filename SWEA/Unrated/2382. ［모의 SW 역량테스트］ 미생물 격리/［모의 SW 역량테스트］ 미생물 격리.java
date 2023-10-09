import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static class point {
		int x, y, num, dir;

		public point(int x, int y, int num, int dir) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

		void move(int dir) {
			switch (dir) {
			case 1:
				x--;
				break; // 상
			case 2:
				x++;
				break; // 하
			case 3:
				y--;
				break; // 좌
			case 4:
				y++;
				break; // 우
			}
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder();
	static int N, M, K, sum;
	static ArrayList<point> microbe;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 세로위치, 가로위치, 미생물 수, 이동방향
		microbe = new ArrayList<>();
		sum = 0;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			microbe.add(new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}

	static void solve() {
		for (int time = 0; time < M; time++) {
			for (int i = 0; i < microbe.size(); i++) {
				microbe.get(i).move(microbe.get(i).dir);
			}
			renewal(microbe);
		}
		for (int i = 0; i < microbe.size(); i++) {
			sum += microbe.get(i).num;
		}
		sb.append(sum);
	}

	private static void renewal(List<point> microbe) {

		for (int i = microbe.size() - 1; i >= 0; i--) {
			point m = microbe.get(i);
			if (m.x == 0 || m.y == 0 || m.x == N - 1 || m.y == N - 1) {

				switch (m.dir) {
				case 1:
					m.dir = 2;
					break;
				case 2:
					m.dir = 1;
					break;
				case 3:
					m.dir = 4;
					break;
				case 4:
					m.dir = 3;
					break;

				}

				microbe.get(i).num /= 2;

			}
		}
		// 삭제 부분
		Map<String, List<point>> map = new HashMap<>();
		
		for (point p : microbe) {
			String key = p.x + ","+p.y;
			
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(p);
		}
		microbe.clear();
		
		for (String key : map.keySet()) {
			List<point> list = map.get(key);
			
			if(list.size() == 1) {
				microbe.add(list.get(0));
				continue;
			}
			
			list.sort((p1, p2) -> Integer.compare(p2.num, p1.num));
			
			for (int i = 1; i < list.size(); i++) {
				list.get(0).num += list.get(i).num;
			}
			microbe.add(list.get(0));
		}

	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			init();
			solve();
			sb.append("\n");
		}
		System.out.println(sb);
	}

}