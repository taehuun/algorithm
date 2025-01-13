import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack;
    static void init() throws IOException {

        String s;

        while(true) {

            s = br.readLine();

            // 종료 조건
            if(s.equals(".")) {
                break;
            }
            sb.append(solution(s)).append('\n');
        }

    }

    public static String solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if(c == '(' || c == '[') {
                stack.push(c);
            }

            else if(c == ')') {
                if(stack.empty() || stack.peek() != '(') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }

            else if(c == ']') {
                if(stack.empty() || stack.peek() != '[') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }
        }

        if(stack.empty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }
}
