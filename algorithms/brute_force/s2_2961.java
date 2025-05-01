import java.io.*;
import java.util.*;

public class s2_2961 {
    static int N;
    static int[][] ingredient;
    static ArrayList<ArrayList<Integer>> combi = new ArrayList<>();
    static ArrayList<Integer> sour = new ArrayList<>();
    static ArrayList<Integer> bitter = new ArrayList<>();

    static void combination(ArrayList<Integer> list, int start, int r) {

        if(list.size() == r) {
            combi.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<N;i++) {
           list.add(i);
           combination(list, i+1, r);
           list.remove(list.size()-1);
        }
    }

    static void mix() {
        for(int i=0; i<combi.size(); i++) {
            int len = combi.get(i).size();
            int mul = 1;
            int sum = 0;
            for(int j=0; j<len; j++) {
                int t = combi.get(i).get(j);
                mul *= ingredient[t][0];
                sum += ingredient[t][1];
            }
            sour.add(mul);
            bitter.add(sum);
        }
    }

    static int minDiff() {
        int len = combi.size();
        int[] diff = new int[len];
        for(int i=0; i<len; i++) {
            diff[i] = Math.abs(sour.get(i)-bitter.get(i));
        }
        return Arrays.stream(diff).min().getAsInt();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            combination(new ArrayList<>(), 0, i);
        }
        mix();
        System.out.println(minDiff());
    }
}

