class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        /*
        0, 0 부터 연결 되어 있는거 있는지 확인 확인하면서 2차원배열 방문 체크 꼭 하면서
        bfs로 연결 상태 확인하면서 true로 묶고 2차원 배열 채워나가자
        다 돈 다음에 count올림
        */
        visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visit[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    static void dfs(int v, int n, int[][] computers){
        visit[v] = true;
        
        for(int i=0; i<n; i++){
            if(computers[v][i] == 1 && !visit[i])
                dfs(i, n, computers);
        }
    }
}