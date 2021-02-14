import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1937 {
    public static int n;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map;
    public static int[][] dp;
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp  = new int[n][n];
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                answer = Math.max(answer, dfs(i,j));
            }
        }
        System.out.println(answer);
    }
    public static int dfs(int x, int y){
        if(dp[x][y]!=0) return dp[x][y];
        dp[x][y] = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n){
                continue;
            }
            if(map[x][y] < map[nx][ny]){
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
            }
        }
        return dp[x][y];
    }

}