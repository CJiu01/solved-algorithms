import java.io.*;
import java.util.*;

public class s5_15721 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> command;
        int n = 1;
        int cnt = 0;
        int people = -1;
        while(sb.length()==0) {
            command = new ArrayList<>(Arrays.asList(0,1,0,1));
            command.addAll(Collections.nCopies(n+1, 0));
            command.addAll(Collections.nCopies(n+1,1));

            while(!command.isEmpty()) {
                int tmp = command.remove(0);
                people += 1;
                if(tmp==target) {
                    cnt += 1;
                    if(cnt==T) {
                        sb.append(people%A);
                        break;
                    }
                }
            }
            n+=1;
        }
        System.out.println(sb);
    }
}
