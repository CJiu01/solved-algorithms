import java.io.*;
import java.util.*;

public class s5_18511 {
    static int N, K, answer;
    static ArrayList<Integer> list = new ArrayList<>();

    static void dfs(int total) {
            
        if(total>N) return;
        if(total>answer) answer = total;

        for(int i=K-1; i>=0; i--) {
            dfs(total*10 + list.get(i));
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        dfs(0);
        System.out.println(answer);
    }
}
