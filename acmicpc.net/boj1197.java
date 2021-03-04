import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1197 {
    public static int V, E;
    public static PriorityQueue<index> map = new PriorityQueue<>();
    public static int[] parent;
    public static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }

        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            map.add(new index(A,B,C));
        }

        int answer = 0;
        while(!map.isEmpty()) {
            index tmp = map.poll();
            if(!isSame(tmp.x, tmp.y)){
                answer += tmp.val;
                union(tmp.x, tmp.y);
            }
        }
        System.out.println(answer);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x<y){
            parent[x] = y;
        }
        else if(x>y){
            parent[y] = x;
        }
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static boolean isSame(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return true;
        return false;
    }
    public static class index implements Comparable<index> {
        int x;
        int y;
        int val;
        public index(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(index o) {
            return this.val - o.val;
        }
    }
}
