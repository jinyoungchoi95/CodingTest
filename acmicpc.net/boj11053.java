import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11053 {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        int[] dp = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(input[i]);
        }
        int answer = 0;
        for(int i=0; i<N; i++){
            dp[i] = 1;
            for(int j=i; j>=0; j--){
                if(map[j] < map[i] && dp[j]>=dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
