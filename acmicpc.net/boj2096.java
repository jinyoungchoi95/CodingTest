import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][3];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(input[0]);
            array[i][1] = Integer.parseInt(input[1]);
            array[i][2] = Integer.parseInt(input[2]);
        }

        long[][] max_dp = new long[N][3];
        long[][] min_dp = new long[N][3];

        min_dp[0][0] = array[0][0];
        max_dp[0][0] = array[0][0];

        min_dp[0][1] = array[0][1];
        max_dp[0][1] = array[0][1];

        min_dp[0][2] = array[0][2];
        max_dp[0][2] = array[0][2];


        for(int i=1; i<N; i++){
            min_dp[i][0] = Math.min(min_dp[i-1][0], min_dp[i-1][1]) + array[i][0];
            min_dp[i][1] = Math.min(min_dp[i-1][0], Math.min(min_dp[i-1][1], min_dp[i-1][2])) + array[i][1];
            min_dp[i][2] = Math.min(min_dp[i-1][1], min_dp[i-1][2]) + array[i][2];

            max_dp[i][0] = Math.max(max_dp[i-1][0], max_dp[i-1][1]) + array[i][0];
            max_dp[i][1] = Math.max(max_dp[i-1][0], Math.max(max_dp[i-1][1], max_dp[i-1][2])) + array[i][1];
            max_dp[i][2] = Math.max(max_dp[i-1][1], max_dp[i-1][2]) + array[i][2];
        }

        long max = Math.max(max_dp[N-1][0], Math.max(max_dp[N-1][1], max_dp[N-1][2]));
        long min = Math.min(min_dp[N-1][0], Math.min(min_dp[N-1][1], min_dp[N-1][2]));

        System.out.printf("%d %d", max, min);
    }
}
