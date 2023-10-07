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
	static int N, M, K;
	static List<point> microbes;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		microbes = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			microbes.add(new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}

	static void solve() { 
	    while(M-- >0){
	        for(point p : microbes){
	            p.move(p.dir);
	        }
	        renewal(microbes);
	    }

	    int sum=0; 

	    for(point p : microbes){ 
		    sum+=p.num;  
	    } 

	    sb.append(sum).append("\n");   
    }

	private static void renewal(List<point> microbes) {

		for (int i = microbes.size() - 1; i >= 0; i--) {
			point m = microbes.get(i);

			if (m.x == 0 || m.y == 0 || m.x == N - 1 || m.y == N - 1) {
				m.num /= 2;
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

				if (m.num == 0)
					microbes.remove(i);
			}
		}

		Map<String, List<point>> map = new HashMap<>();

		for (point p : microbes) {
			String key = p.x + "," + p.y;

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(p);
		}

		microbes.clear();

		for (String key : map.keySet()) {
			List<point> list = map.get(key);

			if (list.size() == 1) {
				microbes.add(list.get(0));
				continue;
			}

			list.sort((p1, p2) -> Integer.compare(p2.num, p1.num));

			point max = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				max.num += list.get(i).num;
			}
			microbes.add(max);
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			init();
			solve();
		}

		System.out.println(sb.toString());
		br.close();
	}
}