import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1238 {
    public static int N, M, X;
    public static ArrayList<index>[] map_go;
    public static ArrayList<index>[] map_back;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);

        map_go = new ArrayList[N+1];
        map_back = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            map_go[i] = new ArrayList<>();
            map_back[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map_back[A].add(new index(B, cost));
            map_go[B].add(new index(A, cost));
        }

        PriorityQueue<index> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        queue.add(new index(X,0));
        int[] go = new int[N+1];
        int[] back = new int[N+1];
        Arrays.fill(go, INF);
        Arrays.fill(back, INF);
        go[X] = 0;
        back[X] = 0;

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            if(visited[tmp.B]) continue;
            visited[tmp.B] = true;

            for(int i=0; i<map_go[tmp.B].size(); i++){
                index next = map_go[tmp.B].get(i);

                if(go[next.B] > go[tmp.B] + next.cost){
                    go[next.B] = go[tmp.B] + next.cost;
                    queue.add(new index(next.B, go[next.B]));
                }
            }
        }

        queue = new PriorityQueue<>();
        visited = new boolean[N+1];
        queue.add(new index(X,0));

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            if(visited[tmp.B]) continue;
            visited[tmp.B] = true;

            for(int i=0; i<map_back[tmp.B].size(); i++){
                index next = map_back[tmp.B].get(i);

                if(back[next.B] > back[tmp.B] + next.cost){
                    back[next.B] = back[tmp.B] + next.cost;
                    queue.add(new index(next.B, back[next.B]));
                }
            }
        }
        int answer = 0 ;
        for(int i=1; i<=N; i++){
            answer = Math.max(answer, go[i]+back[i]);
        }
        System.out.println(answer);

    }
    public static class index implements Comparable<index> {
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
