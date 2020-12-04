import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        long[] memory = new long[N+1];
        input = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            memory[i] = Integer.parseInt(input[i-1]);
        }
        input = br.readLine().split(" ");
        int[] cost = new int[N+1];
        for(int i=1; i<=N; i++){
            cost[i] = Integer.parseInt(input[i-1]);
        }

        long[][] dp = new long[N+1][10001];
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            for(int j=0; j<=10000; j++){
                if(j>=cost[i]){
                    dp[i][j] = Math.max(dp[i-1][j-cost[i]] + memory[i], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

                if(dp[i][j]>=M) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }
}
