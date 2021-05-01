import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13023 {
    public static int n, m;
    public static ArrayList<Integer>[] map;
    public static boolean[] visited;
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for(int i=0; i<n; i++){
            if(answer == 0) dfs(i, 1);
        }
        System.out.println(answer);
    }
    public static void dfs(int start, int depth) {
        if(depth == 5) {
            answer = 1;
            return;
        }
        visited[start] = true;
        for(int i=0; i<map[start].size(); i++){
            int next = map[start].get(i);
            if(!visited[next]){
                dfs(next, depth+1);
            }
        }
        visited[start] = false;
    }
}
