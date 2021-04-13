import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        long[][][] dp = new long[N+1][L+1][R+1];
        dp[1][1][1] = 1;

        for(int i=2; i<=N; i++){
            for(int l=1; l<=L; l++){
                for(int r=1; r<=R; r++){
                    dp[i][l][r] += dp[i-1][l-1][r];
                    dp[i][l][r] += dp[i-1][l][r-1];
                    dp[i][l][r] += dp[i-1][l][r] * (i-2);
                    dp[i][l][r] %= 1000000007;
                }
            }
        }
        System.out.println(dp[N][L][R]);
    }
}
