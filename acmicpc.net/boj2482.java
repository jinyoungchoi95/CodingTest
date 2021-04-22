import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2482 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][N+1];
        dp[1][1] = 1;
        dp[2][1] = 2;
        dp[3][1] = 3;

        for(int i=4; i<=N; i++){
            dp[i][1] = i;
            for(int j=2; j<=(i+1)/2; j++){
                dp[i][j] = dp[i-1][j] + dp[i-2][j-1];
                dp[i][j] %= 1000000003;
            }
            if(i%2==0) dp[i][i/2] = 2;
        }
        System.out.println(dp[N][K]);
    }
}