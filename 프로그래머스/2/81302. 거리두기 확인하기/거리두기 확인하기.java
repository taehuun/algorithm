import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            char[][] arr = new char[5][5];
            for (int j = 0; j < 5; j++) {
                arr[j] = places[i][j].toCharArray();
            }
            
            boolean isValid = true;
            for (int j = 0; j < 5 && isValid; j++) {
                for (int k = 0; k < 5 && isValid; k++) {
                    if (arr[j][k] == 'P') {
                        if (!bfs(arr, j, k)) {
                            isValid = false;
                        }
                    }
                }
            }
            answer[i] = isValid ? 1 : 0;
        }
        
        return answer;
    }
    
    public static boolean bfs(char[][] arr, int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        que.add(new int[]{x, y, 0});  // 깊이를 큐에 추가
        visited[x][y] = true;
        
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            int depth = current[2];
            
            if (depth >= 2) continue; // 깊이가 2 이상이면 더 이상 확장하지 않음
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (check(nx, ny) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                
                if (arr[nx][ny] == 'P') return false;
                if (arr[nx][ny] == 'O') {
                    que.add(new int[]{nx, ny, depth + 1});
                }
            }
        }
        
        return true;
    }
    
    public static boolean check(int nx, int ny) {
        return nx < 0 || nx >= 5 || ny < 0 || ny >= 5;
    }
}
