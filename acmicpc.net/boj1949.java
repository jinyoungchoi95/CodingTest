import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj1949 {
    public static int N;
    public static int[] cost;
    public static ArrayList<Integer>[] map;
    public static int[][] dp;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        dp = new int[N][2];
        visited = new boolean[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            cost[i] = Integer.parseInt(input[i]);
            dp[i][1] = cost[i];
        }
        map = new ArrayList[N];
        for(int i=0; i<N; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0])-1;
            int b = Integer.parseInt(input[1])-1;
            map[a].add(b);
            map[b].add(a);
        }
        dfs(0);
        int answer = Math.max(dp[0][0], dp[0][1]);
        System.out.println(answer);

    }
    public static void dfs(int a){
        visited[a] = true;
        for(int i=0; i<map[a].size(); i++){
            int b = map[a].get(i);
            if(visited[b]) continue;
            dfs(b);
            dp[a][0] += Math.max(dp[b][0],dp[b][1]);
            dp[a][1] += dp[b][0];
        }
    }

}
