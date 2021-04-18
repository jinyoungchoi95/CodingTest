import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1102 {
    public static int N;
    public static int[][] map;
    public static int[] dp;
    public static int limit;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[1<<N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            Arrays.fill(dp, Integer.MAX_VALUE);
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int visited = 0;
        int count = 0;
        String now = br.readLine();
        for(int i=0; i<now.length(); i++){
            if(now.charAt(i)=='Y'){
                count++;
                visited |= 1<<i;
            }
        }
        limit = Integer.parseInt(br.readLine());
        if(count>=limit){
            System.out.println(0);
            return;
        }
        dp[visited] = 0;
        dfs(count, visited);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
    public static void dfs(int count, int visited) {
        if(count == limit){
            answer = Math.min(answer, dp[visited]);
            return;
        }

        for(int i=0; i<N; i++){
            int check = (visited | (1<<i));
            if((check|visited) != visited) continue;
            for(int j=0; j<N; j++){
                int next = (visited | (1<<j));
                if((next|visited) == visited) continue;
                if(dp[visited] + map[i][j] < dp[next]){
                    dp[next] = dp[visited] + map[i][j];
                    dfs(count+1, next);
                }
            }
        }
    }
}