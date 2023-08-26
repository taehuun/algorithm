import java.io.*;
import java.util.*;

public class Main {
	
		static char[][] map;
		static boolean[][] isVisited;	
		static int n, count;	//n:지도의 크기  count:단지의 크기
		static List<Integer> house = new ArrayList<>();	//단지의 크기를 저장할 리스트
		static Deque<Point> q = new ArrayDeque<>();	//인근 단지 탐색에 사용하는 큐
		// 우 하 좌 상
		static int[] dr = { 0, 1, 0, -1 };
		static int[] dc = { 1, 0, -1, 0 };
	
		static void bfs() {
				//인근에 단지가 없을 때가지 반복
				while (!q.isEmpty()) {
						Point now = new Point(q.peek().x, q.peek().y);	//현재 좌표
						q.poll();
						map[now.x][now.y] = 0; // 방문처리
						//우하좌상 탐색
						for (int i = 0; i < 4; i++) {
								int newX = now.x + dr[i];
								int newY = now.y + dc[i];
								//새로운 좌표가 지도 내에 있고 집이면서 이전에 방문하지 않았다면 큐에 추가
								if (checkIndex(newX, newY) && map[newX][newY] == '1' && !isVisited[newX][newY]) {
										isVisited[newX][newY] = true;
										count++;
										q.add(new Point(newX, newY));
								}
						}
				}
				//인근 단지 탐색이 모두 끝나면  house리스트에 현재 단지 크기 저장
				house.add(count);
		}
	
		// 새로운 좌표가 단지 내에 있는지 확인하는 함수
		static boolean checkIndex(int x, int y) {
				if (0 <= x && x < n && 0 <= y && y < n)
						return true;
				return false;
		}
	
		// 단지내 집의 좌표 정보를 가지는 클래스
		static class Point {
				int x;
				int y;
		
				public Point(int x, int y) {
						super();
						this.x = x;
						this.y = y;
				}
		}
	
		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer(br.readLine());
				StringBuilder sb = new StringBuilder();
		
				n = Integer.parseInt(st.nextToken()); // 지도 크기
				// 지도 입력
				map = new char[n][n];
				for (int i = 0; i < n; i++) {
						st = new StringTokenizer(br.readLine());
						String row = st.nextToken();
						map[i] = row.toCharArray();
				}
				
				isVisited = new boolean[n][n];	//방문여부 확인에 사용
		
				for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
								if (map[i][j] == '1') {	//현재 위치가 집이라면 인근 집 탐색
										count = 1;
										q.add(new Point(i, j));
										isVisited[i][j] = true;
										bfs();
								}
						}
					}
		
				//단지의 크기 오름차순 정렬
				Collections.sort(house);
				//출력
				sb.append(house.size()).append("\n"); //단지의 개수
				for (Integer i : house) { //모든 단지의 크기 오름차순으로 출력
						sb.append(i).append("\n");
				}
				System.out.println(sb.toString());
		}
}