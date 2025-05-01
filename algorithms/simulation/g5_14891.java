import java.io.*;
import java.util.*;

public class g5_14891 {
    static ArrayList<ArrayList<Integer>> wheel = new ArrayList<>();

    static int[] determineRotationDirection(int target, int di) {
        int[] direction = new int[4];
        direction[target] = di;

        //L
        for(int i=target; i>0; i--) {
            int now = wheel.get(i).get(6);
            int pre = wheel.get(i-1).get(2);

            if(now==pre) break;
            direction[i-1] = -direction[i];
        }

        //R
        for(int i=target; i<3; i++) {
            int now = wheel.get(i).get(2);
            int next = wheel.get(i+1).get(6);

            if(now==next) break;
            direction[i+1] = -direction[i];
        }
        return direction;
    }

    static void rotate(int[] direction) {
        for(int i=0; i<4; i++) {
            if(direction[i] != 0){
                switch(direction[i]) {
                    case 1:
                        // 시계
                        int last = wheel.get(i).remove(7);
                        wheel.get(i).add(0, last);
                        break;
                    case -1:
                        // 반시계
                        int first = wheel.get(i).remove(0);
                        wheel.get(i).add(7, first);
                        break;
                }
            }
        }
    }

    static int score() {
        int point = 1;
        int res = 0;
        for(int i=0; i<4; i++) {
            if(wheel.get(i).get(0)==1) res+=point;
            point*=2;
        }
        return res;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++) {
            String input = br.readLine();
            ArrayList<Integer> row = new ArrayList<>();

            for(char ch: input.toCharArray()) 
                row.add(ch-'0');
            wheel.add(row);
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int di = Integer.parseInt(st.nextToken());

            int[] res = determineRotationDirection(target-1, di);
            rotate(res);
        }

        System.out.println(score());
    }
}
