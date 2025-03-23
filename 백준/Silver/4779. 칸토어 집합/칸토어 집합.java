import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[] map;
    static void solution() throws IOException {

        String str = "";

        while((str = br.readLine()) != null && !str.isEmpty())  {
            int n = Integer.parseInt(str.trim());

            //전체 길이 구하기
            int len = (int)Math.pow(3, n);
            map = new char[len];

            for(int i=0; i<len; i++) {
                map[i] = ' ';
            }
            go(len, 0);

            for(int i=0; i<len; i++) {
                sb.append(map[i]);
            }
            sb.append("\n");
        }
        // 마지막 개행 문자 제거 (sb가 비어 있지 않을 경우만)
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static void go (int size, int start) {

        if (size == 1){
            map[start] = '-';
            return;
        }

        for (int i=0; i<3; i++) {

            if(i==1) continue;

            go(size/3, start+(i*size/3));
        }

    }

    public static void main(String[] args) throws IOException {

        solution();
        System.out.println(sb);
    }
}
