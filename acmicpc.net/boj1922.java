import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1922 {
    public static int N, M;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        PriorityQueue<index> queue = new PriorityQueue<>();

        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            queue.add(new index(a,b,cost));
        }
        int answer = 0;
        while(!queue.isEmpty()){
            index tmp = queue.poll();

            int a = find(tmp.a);
            int b = find(tmp.b);
            if(a==b) continue;

            union(a,b);
            answer += tmp.cost;
        }
        System.out.println(answer);
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a>b){
            parent[a] = b;
        }
        else{
            parent[b] = a;
        }
    }
    public static class index implements Comparable<index> {
        int a;
        int b;
        int cost;
        public index(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(index o) {
            return this.cost - o.cost;
        }
    }
}
