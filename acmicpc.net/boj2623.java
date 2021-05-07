import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2623 {
    public static int n, m;
    public static ArrayList<Integer>[] map;
    public static int[] indegree;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];
        indegree = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }

        for(int j=0; j<m; j++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for(int i=0; i<count-1; i++){
                int num = Integer.parseInt(st.nextToken());
                indegree[num]++;
                map[prev].add(num);
                prev = num;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        if(queue.isEmpty()){
            System.out.println(0);
            return;
        }
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()) {
            int tmp = queue.poll();

            sb.append(tmp + "\n");
            visited[tmp] = true;

            for(int i=0; i<map[tmp].size(); i++){
                int next = map[tmp].get(i);
                indegree[next]--;
                if(indegree[next]<=0 && !visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
