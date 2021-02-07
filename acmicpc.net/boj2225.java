import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long[][] dp = new long[K+1][N+1];
        Arrays.fill(dp[1], 1);
        for(int i=2; i<=K; i++){
            dp[i][0] = 1;
            for(int j=1; j<=N; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
            }
        }
        System.out.println(dp[K][N]);
    }
}