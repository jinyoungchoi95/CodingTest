import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] array = new int[N+1][2];
        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(input[0]);
            array[i][1] = Integer.parseInt(input[1]);
        }
        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            int weight = array[i][0];
            int value = array[i][1];
            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=weight){
                    dp[i][j] = Math.max(dp[i][j], value + dp[i-1][j-weight]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}