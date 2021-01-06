import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1520 {
    public static int N,M;
    public static int[][] dp;
    public static int[][] array;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        array = new int[N][M];
        dp = new int[N][M];
        for(int i=0; i<N; i++){
            input= br.readLine().split(" ");
            for(int j=0; j<M; j++){
                array[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;
            }
        }
        int answer = dfs(0,0);
        System.out.println(answer);


    }
    public static int dfs(int x, int y){
        if(x==N-1 && y==M-1){
            return 1;
        }

        if(dp[x][y] == -1){
            dp[x][y] = 0;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(array[x][y] > array[nx][ny]){
                        dp[x][y] += dfs(nx, ny);
                    }
                }
            }
        }
        return dp[x][y];

    }
}
