import java.io.*;
import java.util.*;

public class s2_15787 {
    static int[][] train;

    static void set() {
        for(int i=0; i<train.length; i++) {
            Arrays.fill(train[i], 0);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        train = new int[N][21];
        set();

        while(M-- >0) {
            int[] command = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

            switch (command[0]) {
                case 1:
                    // 탑승
                    train[command[1]][command[2]] = 1;
                    break;

                case 2:
                    // 하차
                    train[command[1]][command[2]] = 0;
                    break;

                case 3:
                    // 한칸씩 뒤로(맨뒤는 버림)
                    for(int i=19;i>0;i--) {
                        train[command[1]-1][i+1] = train[command[1]][i];
                    }
                    train[command[1]][1] = 0;
                    break;

                case 4:
                    // 한칸씩 앞으로(맨앞은 버림)
                    for(int i=2;i<20;i++) {
                        train[command[1]-1][i-1] = train[command[1]][i];
                    }
                    train[command[1]][20] = 0;
                    break;
            }
            
        }

        int res = 0;
        String[] stringTrain = new String[N];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.setLength(0);
            for(int num: train[i]) {
                sb.append(num);
            }
            stringTrain[i] = sb.toString();
        }

        System.out.println(Arrays.toString(stringTrain));
        Set<String> set = new HashSet<>(Arrays.asList(stringTrain));
        System.out.println(set);
        System.out.println(set.size());
    }
}
