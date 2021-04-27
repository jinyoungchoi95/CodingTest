import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1939 {
    public static int n, m, start, end;
    public static ArrayList<index>[] map;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        int min = 999999;
        int max = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new index(b,c));
            map[b].add(new index(a,c));
            max = Math.max(max,c);
            min = Math.min(min,c);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while(min<=max){
            int mid = (min+max)/2;

            if(bfs(mid)){
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
    public static boolean bfs(int limit) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n+1];
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int tmp = queue.poll();

            if(tmp == end){
                return true;
            }

            for(int i=0; i<map[tmp].size(); i++){
                index next = map[tmp].get(i);
                if(next.c < limit || visited[next.b]) continue;
                visited[next.b] = true;
                queue.add(next.b);
            }
        }
        return false;
    }
    public static class index {
        int b;
        int c;

        public index(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }
}