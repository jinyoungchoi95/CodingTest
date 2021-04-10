import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2098 {
    public static int N;
    public static int answer = Integer.MAX_VALUE;
    public static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][1<<N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp[0][1] = 0;
        dfs(0, 1);
        System.out.println(answer);
    }
    public static void dfs(int now, int visited){
        if(visited == ((1<<N)-1)){
            if(map[now][0]==0) return;
            int compare = dp[now][visited] + map[now][0];
            answer = Math.min(answer, compare);
            return;
        }

        for(int i=0; i<N; i++){
            int next = (1<<i);
            if((visited | next) == visited) continue;
            if(map[now][i] == 0) continue;
            if(dp[now][visited] + map[now][i] < dp[i][visited|next]){
                dp[i][visited|next] = dp[now][visited] + map[now][i];
                dfs(i, visited|next);
            }
        }
    }
}