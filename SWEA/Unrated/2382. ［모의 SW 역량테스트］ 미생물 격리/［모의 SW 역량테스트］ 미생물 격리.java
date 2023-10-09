import java.util.*;
import java.io.*;

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
	static List<point> microbe;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		microbe = new ArrayList<>();
		sum = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			microbe.add(new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

	}

	static void solve() {
		// 움직이고, 테두리 절반으로, 방향바꾸고, 합칠거 합치고, 삭제하고
		while (M-- > 0) {
			// 1. move
			for (point p : microbe) {
				p.move(p.dir);
			}
			// 2. 테두리 절반으로
			for (point p : microbe) {
				if (p.x == 0 || p.x == N - 1 || p.y == 0 || p.y == N - 1) {
					p.num /= 2;

					// 3. 방향 바꾸고
					switch (p.dir) {
					case 1:
						p.dir = 2;
						break; // 상 -> 하
					case 2:
						p.dir = 1;
						break; // 하 -> 상
					case 3:
						p.dir = 4;
						break; // 좌 -> 우
					case 4:
						p.dir = 3;
						break; // 우 -> 좌
					}
				}
			}
			// 4. 합친다.
			Map<String, List<point>> map = new HashMap<>();
			for (point p : microbe) {
				String key = p.x + "," + p.y;
				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<>());
				}
				map.get(key).add(p);
			}
			microbe.clear();

			for (String key : map.keySet()) {
				List<point> list = map.get(key);
				if (list.size() == 1) {
					microbe.add(list.get(0));
					continue;
				}
				list.sort((o1, o2) -> Integer.compare(o2.num, o1.num));

				for (int i = 1; i < list.size(); i++) {
					list.get(0).num += list.get(i).num;
				}
				microbe.add(list.get(0));
			}
		}
		for (point p : microbe) {
			sum += p.num;
		}
		sb.append(sum);
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