import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1260 {
    public static int N, M, V;
    public static boolean[][] map;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);
        map = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map[a][b] = map[b][a] = true;
        }
        boolean[] visited = new boolean[N+1];
        visited[V] = true;
        sb.append(V + " ");
        dfs(visited, V);
        sb.append("\n");
        sb.append(V + " ");
        bfs();
        System.out.println(sb.toString());
    }
    public static void dfs(boolean[] visited, int index){
        for(int i=1; i<=N; i++){
            if(!visited[i] && map[i][index]){
                visited[i] = true;
                sb.append(i + " ");
                dfs(visited, i);
            }
        }
    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        visited[V] = true;
        queue.add(V);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i=1; i<=N; i++){
                if(!visited[i] && map[i][tmp]){
                    visited[i] = true;
                    queue.add(i);
                    sb.append(i + " ");
                }
            }
        }
    }
}
