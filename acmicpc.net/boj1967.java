import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1967 {
    public static int n;
    public static ArrayList<index>[] list;
    public static int max = 0;
    public static int max_idx = 1;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new index(b,c));
            list[b].add(new index(a,c));
        }
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[n+1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);
    }
    public static void dfs(int idx, int count){
        if(max<count) {
            max = count;
            max_idx = idx;
        }
        for(int i=0; i<list[idx].size(); i++){
            if(!visited[list[idx].get(i).idx]){
                visited[list[idx].get(i).idx] = true;
                dfs(list[idx].get(i).idx, count + list[idx].get(i).value);
            }
        }
    }
    public static class index{
        int idx;
        int value;
        public index(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
}
