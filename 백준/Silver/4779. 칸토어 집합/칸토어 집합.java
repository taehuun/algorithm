import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void solution() throws IOException {

        String str;
        while ((str = br.readLine()) != null) { // EOF 처리
            if (str.trim().isEmpty()) { // 빈 줄 무시
                continue;
            }

            sb.setLength(0);
            int n = Integer.parseInt(str.trim()); // 공백 제거 후 변환

            int len = (int) Math.pow(3, n);
            // 전체 길이 '-'로 초기화
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            // 칸토어 집합 생성
            go(0, len);
            System.out.println(sb);
        }
    }

    static void go(int start, int size) {
        if (size < 3) return;

        int newSize = size / 3;

        for (int i = start + newSize; i < start + newSize * 2; i++) {
            sb.setCharAt(i, ' ');
        }

        go(start, newSize);
        go(start + newSize * 2, newSize);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
