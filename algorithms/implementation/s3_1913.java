import java.io.*;
import java.util.*;

public class s3_1913 {
    static int N;
    static int[][] arr;
    static int target;
    static StringBuilder sb = new StringBuilder();

    static void move() {

        int num = 1;
        int re = 2;
        int[][] di = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        int key = 0;
    
        int i = N/2;
        int j = N/2;
        arr[i][j] = num++;
        while(num<=N*N) {

            for(int a=0; a<re/2; a++) {
                if(num>N*N) break;

                i += di[key%4][0];
                j += di[key%4][1];
                
                if(num == target) {
                    sb.append(i+1+" ").append(j+1);
                }
                arr[i][j] = num++;
            }
            key += 1;
            re += 1;
        }
    }

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        target = Integer.parseInt(br.readLine());
        
        move();
        for(int[] a: arr) {
            for(int b: a) {
                System.out.print(b+" ");
            }
            System.out.println();
        }
        System.out.println(sb.length()==0 ? (N/2+1)+" "+(N/2+1) : sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
