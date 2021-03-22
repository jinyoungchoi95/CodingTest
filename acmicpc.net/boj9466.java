import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj9466 {
    public static int count;
    public static int[] link;
    public static boolean[] finished, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            finished = new boolean[n+1];
            visited = new boolean[n+1];
            count = 0;

            link = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                link[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                if(!finished[i]){
                    dfs(i);
                }
            }
            sb.append(n-count);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int now){
        if(visited[now]){
            finished[now] = true;
            count++;
        }
        else{
            visited[now] = true;
        }

        int next = link[now];
        if(!finished[next]){
            dfs(next);
        }

        visited[now] = false;
        finished[now] = true;
    }
}
