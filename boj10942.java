import java.io.*;
import java.util.*;

public class boj10942 {
    public static int N;
    public static int[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        array = new int[N+1];
        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(input[i-1]);
        }

        boolean[][] dp = new boolean[N+1][N+1];
        Makedp(dp);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testcase=0; testcase<M; testcase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(dp[S][E]) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.println(String.valueOf(sb));
    }
    public static void Makedp(boolean[][] dp){
        for(int i=1; i<=N; i++){
            dp[i][i] = true;
        }
        for(int i=1; i<=N-1; i++){
            if(array[i]==array[i+1]){
                dp[i][i+1] = true;
            }
        }
        for(int i=3; i<=N; i++){
            for(int j=1; j<=N-i+1; j++){
                int end_j = j + i -1;
                if(array[j]==array[end_j]){
                    if(dp[j+1][end_j-1]){
                        dp[j][end_j] = true;
                    }
                }
            }
        }
    }


}
