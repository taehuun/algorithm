import java.util.*;
import java.io.*;

class Solution {

    static int[] dx = {1, -1, 0, 0}; // 남(N), 북(S), 동(E), 서(W) 순서
    static int[] dy = {0, 0, 1, -1};
    static int[] point = new int[2]; // 로봇 강아지의 현재 위치
    static int h, w; // 공원의 높이와 너비

    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        w = park[0].length();

        // 시작점 초기화
        init(park);

        // 각 명령을 처리
        for (String route : routes) {
            String[] arr = route.split(" ");
            String dir = arr[0];
            int dis = Integer.parseInt(arr[1]);

            if (!move(dir, dis, park)) {
                continue; // 이동 불가하면 해당 명령을 무시하고 다음으로
            }
        }

        return point; // 최종 위치 반환
    }

    // 시작점(S)을 찾는 함수
    static void init(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    point[0] = i; // 세로 좌표
                    point[1] = j; // 가로 좌표
                    return;
                }
            }
        }
    }

    // 이동을 처리하는 함수
    static boolean move(String dir, int dis, String[] park) {
        int x = point[0];
        int y = point[1];

        int dirIndex = -1;

        // 방향에 따른 인덱스 설정
        switch (dir) {
            case "S": dirIndex = 0; break; // 남쪽
            case "N": dirIndex = 1; break; // 북쪽
            case "E": dirIndex = 2; break; // 동쪽
            case "W": dirIndex = 3; break; // 서쪽
        }

        // 주어진 거리만큼 이동을 시도
        for (int i = 0; i < dis; i++) {
            int nx = x + dx[dirIndex];
            int ny = y + dy[dirIndex];

            // 범위를 벗어나거나 장애물을 만나면 이동 실패
            if (nx < 0 || nx >= h || ny < 0 || ny >= w || park[nx].charAt(ny) == 'X') {
                return false;
            }

            // 이동 가능하면 좌표 업데이트
            x = nx;
            y = ny;
        }

        // 이동 성공한 경우 로봇의 위치를 업데이트
        point[0] = x;
        point[1] = y;
        return true;
    }
}