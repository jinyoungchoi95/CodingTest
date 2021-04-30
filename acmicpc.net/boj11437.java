import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11437 {
    public static int n;
    public static ArrayList<Integer>[] map;
    public static int[] depth;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n+1];
        depth = new int[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }
        Queue<Integer> depthCal = new LinkedList<>();
        depthCal.add(1);
        parent[1] = -1;
        while(!depthCal.isEmpty()){
            int now = depthCal.poll();

            for(int i=0; i<map[now].size(); i++){
                int next = map[now].get(i);
                if(parent[next] != 0) continue;
                parent[next] = now;
                depth[next] = depth[now] + 1;
                depthCal.add(next);
            }
        }
        parent[1] = 1;
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(findParent(a, depth[a], b, depth[b]));
        }
    }
    public static int findParent(int a, int aDepth, int b, int bDepth) {
        while(a != b) {
            if(aDepth <= bDepth) {
                b = parent[b];
                bDepth--;
            }
            else{
                a = parent[a];
                aDepth--;
            }
        }
        return a;
    }

}
