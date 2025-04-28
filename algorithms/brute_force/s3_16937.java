import java.io.*;
import java.util.*;

public class s3_16937 {
    static int H, W, N;
    static int[][] stickers;

    static int solvedDimention(int idx1,int idx2) {

        int[] sticker1 = stickers[idx1];
        int[] sticker2 = stickers[idx2];
        boolean flag = false;

        // (x,x) ver
        if(Math.max(sticker1[0],sticker2[0])<=W && sticker1[1]+sticker2[1]<=H) flag = true;
        // (x,x) hor
        else if(sticker1[0]+sticker2[0]<=W && Math.max(sticker1[1],sticker2[1])<=H) flag = true;
        // (0,x) ver
        else if(Math.max(sticker1[1],sticker2[0])<=W && sticker1[0]+sticker2[1]<=H) flag = true;
        // (0,x) hor
        else if(sticker1[1]+sticker2[0]<=W && Math.max(sticker1[0],sticker2[1])<=H) flag = true;
        // (x,0) ver
        else if(Math.max(sticker1[0],sticker2[1])<=W && sticker1[1]+sticker2[0]<=H) flag = true;
        // (x,0) hor
        else if(sticker1[0]+sticker2[1]<=W && Math.max(sticker1[1],sticker2[0])<=H) flag = true;
        // (0,0) ver
        else if(Math.max(sticker1[1],sticker2[1])<=W && sticker1[0]+sticker2[0]<=H) flag = true;
        // (0,0) hor
        else if(sticker1[1]+sticker2[1]<=W && Math.max(sticker1[0],sticker2[0])<=H) flag = true;

        if(flag) {
            return (sticker1[0]*sticker1[1] + sticker2[0]*sticker2[1]);
        }
        return 0;
    }

    static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        stickers = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                result = Math.max(result, solvedDimention(i, j));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());;
    }
}
