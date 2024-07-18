import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int hour, min, time, ans;
    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        hour = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(br.readLine());
    }

    static void sovle() {
        min += time;
        if (min >= 60){
            hour += min/60;
            min = min%60;
        }
        if (hour >= 24){
            hour %= 24;
        }
        System.out.println(hour + " " + min);
    }

    public static void main(String[] args) throws IOException{

        init();
        sovle();
    }
}
