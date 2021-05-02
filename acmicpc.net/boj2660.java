import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2660 {
    public static int n;
    public static int[][] map;
    public static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        depth = new int[n+1];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1) break;
            map[a][b] = map[b][a] = 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            bfs(i);
            min = Math.min(min, depth[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=1; i<=n; i++){
            if(depth[i] == min) list.add(i);
        }
        System.out.printf("%d %d\n", min, list.size());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    public static void bfs(int start) {
        Queue<index> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        queue.add(new index(start, 0));
        int max = 0;

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            for(int i=1; i<=n; i++){
                if(visited[i] || map[tmp.x][i]==0) continue;
                visited[i] = true;
                max = Math.max(max, tmp.depth+1);
                queue.add(new index(i, tmp.depth+1));
            }
        }
        depth[start] = max;
    }
    public static class index {
        int x;
        int depth;

        public index(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }
}
