import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17070 {
    public static int[] dx = {0, 0, 1, 1};
    public static int[] dy = {0, 1, 1, 0};
    public static int answer = 0;
    public static int N;
    public static int[][] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                house[i][j] = Integer.parseInt(input[j]);
            }
        }
        int[][] dp = new int[N][N];
        dp[0][1] = 1;
        dfs(0,1,dp);
        System.out.println(answer);

    }
    public static void dfs(int x, int y, int[][] dp){
        if(house[x][y]==1){
            return;
        }
        if(dp[x][y]==2 && (house[x-1][y]==1 || house[x][y-1]==1)){
            return;
        }

        if(x==N-1 && y==N-1){
            answer++;
            return;
        }


        if(dp[x][y]!=3 && check(x,y,1)){
            int nx = x + dx[1];
            int ny = y + dy[1];
            dp[nx][ny] = 1;
            dfs(nx,ny,dp);
        }

        if(check(x,y,2)){
            int nx = x + dx[2];
            int ny = y + dy[2];
            dp[nx][ny] = 2;
            dfs(nx,ny,dp);
        }
        if(dp[x][y]!=1 && check(x,y,3)){
            int nx = x + dx[3];
            int ny = y + dy[3];
            dp[nx][ny] = 3;
            dfs(nx,ny,dp);
        }


    }
    public static boolean check(int x, int y, int i){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx<0 || ny<0 || nx>=N || ny>=N){
            return false;
        }
        return true;
    }
}
