import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        Arrays.fill(dp[1], 1);
        for(int i=2; i<65; i++){
            for(int j=0; j<=9; j++){
                for(int k=j; k<=9; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        for(int test=0; test<T; test++){
            int N = Integer.parseInt(br.readLine());
            long answer = 0;
            for(int i=0; i<=9; i++){
                answer += dp[N][i];
            }
            System.out.println(answer);
        }
    }
}
