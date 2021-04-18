import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17404 {
    public static int N;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            dp[1][(i+1)%3] = map[0][i] + map[1][(i+1)%3];
            dp[1][(i+2)%3] = map[0][i] + map[1][(i+2)%3];
            dp[1][i] = Integer.MAX_VALUE;
            for(int j=2; j<N; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + map[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + map[j][1];
                dp[j][2] = Math.min(dp[j-1][1], dp[j-1][0]) + map[j][2];
            }
            answer = Math.min(answer, Math.min(dp[N-1][(i+1)%3], dp[N-1][(i+2)%3]));
        }
        System.out.println(answer);
    }

}