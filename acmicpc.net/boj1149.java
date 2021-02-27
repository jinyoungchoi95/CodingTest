import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N+1][3];
        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");
            house[i][0] = Integer.parseInt(input[0]);
            house[i][1] = Integer.parseInt(input[1]);
            house[i][2] = Integer.parseInt(input[2]);
        }
        int[][] dp = new int[N+1][3];

        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
        for(int i=1; i<=N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
        }
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

    }
}