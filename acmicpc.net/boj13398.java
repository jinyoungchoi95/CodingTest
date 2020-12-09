import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        String[] input = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(input[i-1]);
        }

        long[][] dp = new long[n+1][2];
        long max = dp[1][0] = dp[1][1] = num[1];

        for(int i=2; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][0] + num[i], num[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + num[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(max);
    }
}
