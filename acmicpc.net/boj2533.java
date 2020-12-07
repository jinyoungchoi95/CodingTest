import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj2533 {
    public static LinkedList<Integer>[] linked;
    public static boolean[] visited;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        linked = new LinkedList[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1][2];
        for(int i=1; i<=N; i++){
            linked[i] = new LinkedList<>();
        }
        for(int i=0; i<N-1; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            linked[a].add(b);
            linked[b].add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }
    public static void dfs(int index){
        visited[index] = true;
        //if index == early adopter
        dp[index][0] = 0;
        //if index != early adopter
        dp[index][1] = 1;

        LinkedList<Integer> list = linked[index];

        for(int i=0; i<list.size(); i++){
            int index2 = list.get(i);
            if(!visited[index2]){
                dfs(index2);
                dp[index][0] += dp[index2][1];
                dp[index][1] += Math.min(dp[index2][0], dp[index2][1]);
            }
        }

    }
}
