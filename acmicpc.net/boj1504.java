import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1504 {
    public static int N, E;
    public static ArrayList<index>[] map;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        map = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new index(b,c));
            map[b].add(new index(a,c));
        }
        input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int answer = -1;
        int ab = find_road(a,b);
        int ba = find_road(b,a);
        if(ab == INF && ba == INF) System.out.println(answer);
        else{
            answer = Math.min(ab, ba);
            System.out.println(answer);
        }
    }
    public static int find_road(int a, int b) {
        int x = bfs(1,a);
        int y = bfs(a,b);
        int z = bfs(b,N);
        if(x==INF || y==INF || z==INF) return INF;
        return x+y+z;
    }
    public static int bfs(int start, int end) {
        PriorityQueue<index> queue = new PriorityQueue<>();
        queue.add(new index(start, 0));
        boolean[] visited = new boolean[N+1];
        int[] value = new int[N+1];
        Arrays.fill(value, INF);
        value[start] = 0;

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            if(tmp.B == end) return value[tmp.B];

            if(visited[tmp.B]) continue;
            visited[tmp.B] = true;

            for(int i=0; i<map[tmp.B].size(); i++){
                index next = map[tmp.B].get(i);

                if(value[next.B] > value[tmp.B] + next.cost){
                    value[next.B] = value[tmp.B] + next.cost;
                    queue.add(new index(next.B , value[next.B]));
                }
            }
        }
        return INF;
    }
    public static class index implements Comparable<index> {
        int B;
        int cost;
        public index(int B, int cost){
            this.B = B;
            this.cost = cost;
        }
        public int compareTo(index o){
            return this.cost - o.cost;
        }
    }
}
