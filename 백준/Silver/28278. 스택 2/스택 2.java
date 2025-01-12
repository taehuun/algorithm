import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack;
    static int N;

    static void init() throws IOException {

        stack = new Stack<>();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            solution(br.readLine());
        }
    }

    static void solution(String a) {

        char chr = a.charAt(0);

        switch (chr){

            case '1' :
                stack.push(Integer.parseInt(a.substring(2)));
                break;
            case '2' :
                if(stack.empty())
                    sb.append(-1);
                else
                    sb.append(stack.pop());
                sb.append("\n");
                break;
            case '3' :
                sb.append(stack.size()).append("\n");
                break;
            case '4' :
                if(stack.empty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append("\n");
                break;
            case '5' :
                if(stack.empty())
                    sb.append(-1);
                else
                    sb.append(stack.peek());
                sb.append("\n");
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
