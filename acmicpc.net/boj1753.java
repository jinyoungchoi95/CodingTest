import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {
    public static int V, E, K;
    public static ArrayList<index>[] map;
    public static int[] distance;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        map = new ArrayList[V+1];
        distance = new int[V+1];
        for(int i=0; i<=V; i++){
            map[i] = new ArrayList<>();
        }
        Arrays.fill(distance, INF);

        K = Integer.parseInt(br.readLine());
        distance[K] = 0;

        StringTokenizer st;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[u].add(new index(v,w));
        }
        StringBuilder sb = new StringBuilder();
        dfs(K);
        for(int i=1; i<=V; i++){
            if(distance[i]==INF) sb.append("INF\n");
            else sb.append(distance[i] + "\n");
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int start) {
        PriorityQueue<index> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        queue.add(new index(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            int cur = tmp.x;

            if(visited[cur]) continue;
            visited[cur] = true;

            for(index node : map[cur]){
                if(distance[node.x] > distance[cur] + node.dis){
                    distance[node.x] = distance[cur] + node.dis;
                    queue.add(new index(node.x, distance[node.x]));
                }
            }
        }
    }
    public static class index implements Comparable<index> {
        int x;
        int dis;
        public index(int x, int dis){
            this.x = x;
            this.dis = dis;
        }

        @Override
        public int compareTo(index o) {
            return this.dis - o.dis;
        }
    }

}

