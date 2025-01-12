import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<String> stack;
    static int N;

    static void init() throws IOException {

        stack = new Stack<>();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String a = br.readLine();
            solution(a);
        }
    }

    static void solution(String a) {

        if(a.length() == 1){
            if(a.equals("2")){
                if(stack.empty()){
                    System.out.println(-1);
                }else {
                    System.out.println(stack.pop());
                }
            }else if(a.equals("3")){
                System.out.println(stack.size());
            }else if (a.equals("4")){
                if(stack.empty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }else if (a.equals("5")){
                if(stack.empty()){
                    System.out.println(-1);
                }else {
                    System.out.println(stack.peek());
                }
            }
        }
        //1경우
        else {
            stack.add(a.substring(2));
        }
    }

    public static void main(String[] args) throws IOException {
        init();
    }
}
