import java.io.*;
import java.util.*;

public class s4_4396 {
    static String[][] com;
    static int N;

    static int countBomb(int a, int b) {
        int cnt = 0;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1},  {1, 0}, {1, 1}};        
        for(int i=0; i<8; i++) {
            int row = a+dir[i][0];
            int col = b+dir[i][1];

            if(row>=0 && row<N && col>=0 && col<N) {
                cnt += (com[row][col].equals("*") ? 1 : 0);
            }
            
        }
        return cnt;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        com = new String[N][N];
        for(int i=0; i<N; i++) {
            String[] tmp = br.readLine().split("");
            for(int j=0;j<N;j++) {
                com[i][j] = tmp[j];
            }
        }
        
        String[][] user = new String[N][N];
        for(int i=0; i<N; i++) {
            String[] tmp = br.readLine().split("");
            for(int j=0;j<N;j++) {
                user[i][j] = tmp[j];
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        boolean bomb = false;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(user[i][j].equals("x")) {
                    if(com[i][j].equals("*")) {
                        bomb = true;
                    } else {
                        res.add(countBomb(i, j));
                    }
                    
                } 
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(user[i][j].equals("x")) {
                    if(com[i][j].equals(".")) {
                        sb.append(res.remove(0));
                    } else {
                        sb.append("*");
                    }

                } else {
                    if(bomb) {
                        sb.append(com[i][j].equals("*") ? "*" : ".");
                    } else {
                        sb.append(".");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
