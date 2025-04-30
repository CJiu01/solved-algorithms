import java.io.*;
import java.util.*;

public class g5_20165 {
    static int N,M;
    static int[][] board;
    static int[][] user;
    static int scrore;
    static StringBuilder sb = new StringBuilder();

    static void offend(int row, int col, int direction) {

        int[][] di = {{0,1},{0,-1},{1,0},{-1,0}};
        int step = user[row][col];

        while(step-->1) {
            if(row>=N || row<0 || col>=M || col<0) break;

            if(user[row][col] != 0){
                step = Math.max(step, user[row][col]);
                user[row][col] = 0;
                scrore += 1;
            }

            row += di[direction][0];
            col += di[direction][1];
        }
    }

    static void defend(int row, int col) {
        user[row][col] = board[row][col];
        return;
    }

    static void convertFormat() {
        sb.append(scrore).append("\n");
        for(int[] row: user) {
            for(int col: row) {
                String res = (col==0 ? "F" : "S");
                sb.append(res).append(" ");
            }
            sb.append("\n");            
        }
    }

    static int direction(String s) {
        switch (s) {
            case "E":
                return 0;
            case "W":
                return 1;
            case "S":
                return 2;
            case "N":
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        user = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                user[i][j] = board[i][j];
            }
        }


        int row, col, dir;
        while(R-- > 0) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            dir = direction(st.nextToken());
            offend(row-1, col-1, dir);
            
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            defend(row-1, col-1);
            
        }

        convertFormat();
        System.out.println(sb);

    }
}
