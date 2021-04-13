import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11062 {
    public static int N;
    public static int[] num;
    public static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test=0; test<T; test++) {
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            String[] input = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(input[i]);
            }
            dp = new int[2][N][N];
            System.out.println(dfs(0, N-1, 0));
        }
    }
    public static int dfs(int left, int right, int turn){
        if(left > right) return 0;

        if(dp[turn][left][right]!=0) return dp[turn][left][right];

        if(turn == 0){
            dp[turn][left][right] = Math.max(dfs(left+1, right, 1) + num[left], dfs(left, right-1, 1) + num[right]);
        }
        else{
            dp[turn][left][right] = Math.min(dfs(left+1, right, 0), dfs(left, right-1, 0));
        }

        return dp[turn][left][right];
    }
}