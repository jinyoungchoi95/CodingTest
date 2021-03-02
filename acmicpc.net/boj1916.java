import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916 {
    public static int N, M;
    public static ArrayList<index>[] map;
    public static int[] value;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        value = new int[N+1];
        Arrays.fill(value, INF);

        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[A].add(new index(B, cost));
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        bfs(start, end);
        System.out.println(value[end]);


    }
    public static void bfs(int start, int end) {
        PriorityQueue<index> queue = new PriorityQueue<>();
        queue.add(new index(start, 0));
        boolean[] visited = new boolean[N+1];
        value[start] = 0;

        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.B == end) break;

            if(visited[tmp.B]) continue;
            visited[tmp.B] = true;

            for(int i=0; i<map[tmp.B].size(); i++){
                index next = map[tmp.B].get(i);

                if(value[next.B] > value[tmp.B] + next.cost) {
                    value[next.B] = value[tmp.B] + next.cost;
                    queue.add(new index(next.B, value[next.B]));
                }
            }
        }

    }
    public static class index implements Comparable<index>{
        int B;
        int cost;
        public index(int B, int cost) {
            this.B = B;
            this.cost = cost;
        }

        @Override
        public int compareTo(index o) {
            return this.cost - o.cost;
        }
    }
}
