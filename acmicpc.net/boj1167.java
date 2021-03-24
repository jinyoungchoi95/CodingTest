import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1167 {
    public static int V, max_index, max;
    public static ArrayList<index>[] map;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        map = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            map[i] = new ArrayList<>();
        }
        max = 0;
        for(int t=1; t<=V; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            while(true) {
                int end = Integer.parseInt(st.nextToken());
                if(end == -1) break;
                int len = Integer.parseInt(st.nextToken());
                map[i].add(new index(end, len));
            }
        }
        visited = new boolean[V+1];

        dfs(1, 0, 0);
        Arrays.fill(visited, false);

        dfs(max_index, 0, 0);
        System.out.println(max);
    }
    public static void dfs(int index, int count, int prev) {
        if(max < count){
            max_index = index;
            max = count;
        }
        for(int i=0; i<map[index].size(); i++){
            index next = map[index].get(i);
            if(!visited[next.end] && next.end != prev){
                visited[next.end] = true;
                dfs(next.end, count+next.len, index);
            }
        }
    }
    public static class index{
        int end;
        int len;
        public index(int end, int len) {
            this.end = end;
            this.len = len;
        }
    }
}
