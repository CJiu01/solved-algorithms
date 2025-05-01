import java.io.*;
import java.util.*;

public class s3_15651  {
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    static void dfs(Stack<Integer> stack) {
        if(stack.size() == M) {
            for(int num: stack) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            stack.add(i);
            dfs(stack);
            stack.pop();
        }
        return;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(new Stack<>());
        System.out.println(sb);
    }
}
