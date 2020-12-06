import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2169 {
    public static int N,M;
    public static long minvalue;
    public static long[][] map;
    public static long[][][] dp;
    public static int[] dx = {0, 1, 0};
    public static int[] dy = {-1, 0, 1};
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new long[N][M];
        dp = new long[N][M][3];
        minvalue = -99000000;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Long.parseLong(input[j]);
                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = minvalue;
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;


        System.out.println(dfs(0,0, 0));

    }
    public static long dfs(int x, int y, int direct){
        if(x==N-1 && y==M-1){
            return map[x][y];
        }
        if(dp[x][y][direct] != minvalue){
            return dp[x][y][direct];
        }
        for(int i=0; i<=2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]){
                continue;
            }
            visited[nx][ny] = true;
            dp[x][y][direct] = Math.max(dp[x][y][direct], dfs(nx,ny, i) + map[x][y]);
            visited[nx][ny] = false;
        }

        return dp[x][y][direct];

    }
}
