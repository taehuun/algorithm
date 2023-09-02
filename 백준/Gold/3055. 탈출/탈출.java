import java.io.*;
import java.util.*; 


public class Main {
    static StringBuilder sb = new StringBuilder(); 
    static String[][] map;
    static int R;
    static int C;
    static int[] dx = {1,-1,0,0};
    static int[] dy= {0,0,-1,1};

    //물이 퍼지는 값 
    static int[][] distanceW;
    static boolean[][] WisVisit;
    //고슴도치가 이동한 값 
    static int[][] distanceS; 
    static boolean[][] SisVisit; 


    static int DestinationX;
    static int DestinationY; 
    // , 빈공간 
    // * 물
    // X 돌 
    //비버굴 D 
    //고슴도치 위치 S 

    //고슴도치가 이동하는 로직  
        //만약 dista
    //물이 이동하는 로직, * D와 X는 이동불가임 


    //

    static boolean isNotValid(int x, int y){
        return x<0||y<0||x>=R||y>=C;
    }

    static Queue<int[]> Sque = new LinkedList<>(); 
    static void SBFS(){
        while(!Sque.isEmpty()){
            int[] current = Sque.poll(); 
            for(int i=0; i<4; i++){
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if(isNotValid(nextX, nextY)){continue;}
                if(SisVisit[nextX][nextY]){continue;}
                if(map[nextX][nextY].equals("*")||map[nextX][nextY].equals("X")){continue;}
                int tmpDistance = distanceS[current[0]][current[1]]+1;

                if (distanceW[nextX][nextY] != 0 && distanceW[nextX][nextY] <= tmpDistance) continue; 
                Sque.add(new int[] {nextX, nextY});
                SisVisit[nextX][nextY] = true; 
                distanceS[nextX][nextY] = tmpDistance; 
                
            }
        }
    }


    static Queue<int[]> Wque = new LinkedList<>(); 
    static void WBFS(){
        while(!Wque.isEmpty()){
            int[] current = Wque.poll();
            for(int i=0; i<4; i++){
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                if(isNotValid(nextX, nextY)){continue;}
                if(WisVisit[nextX][nextY]){continue;}
                if(map[nextX][nextY].equals("X")||map[nextX][nextY].equals("D")){continue;}
                Wque.add(new int[] {nextX, nextY});
                WisVisit[nextX][nextY]= true; 
                distanceW[nextX][nextY] = distanceW[current[0]][current[1]] +1; 
            }

        }
    }
    static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(buffer.readLine());

        R = Integer.valueOf(tokens.nextToken());
        C = Integer.valueOf(tokens.nextToken());

        map = new String[R][C];
        distanceW = new int[R][C];
        distanceS = new int[R][C];
        WisVisit = new boolean[R][C];
        SisVisit = new boolean[R][C];

        for(int x=0; x<R; x++){
            tokens = new StringTokenizer(buffer.readLine());
            String Line = tokens.nextToken();
            for(int y =0; y<C; y++){
                map[x][y] = String.valueOf(Line.charAt(y));
                if(map[x][y].equals("*")){
                    Wque.add(new int[] {x,y});
                    WisVisit[x][y] = true; 
                }else if(map[x][y].equals("S")){
                    Sque.add(new int[] {x,y});
                    SisVisit[x][y] = true; 
                }else if(map[x][y].equals("D")){
                    DestinationX = x;
                    DestinationY = y; 
                }
                
            }
        }
    }
    static void print2Darr(String[][] arr){
        for(String[] ar :arr){
            for(String a: ar){
                sb.append(a);
            }sb.append("\n");
        }
    }   
    static void print2Darr(int[][] arr){
        for(int[] ar :arr){
            for(int a: ar){
                sb.append(a);
            }sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        WBFS(); 
        SBFS();
        
        if(distanceS[DestinationX][DestinationY]==0){
            sb.append("KAKTUS");
        }else{
            sb.append(distanceS[DestinationX][DestinationY]);
        }
        
        System.out.println(sb);
        //BFS로 물의 distance를 구한다. 
        //BFS와 물의 distance를 이용해서 고슴도치의 distance를 구한다. 
    }
}