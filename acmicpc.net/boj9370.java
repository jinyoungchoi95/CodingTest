import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9370 {
    public static ArrayList<index>[] link;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test=0; test<T; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            link = new ArrayList[n+1];
            for(int i=0; i<=n; i++){
                link[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if((a==g&&b==h) || (a==h&&b==g)){
                    link[a].add(new index(b, d*2-1));
                    link[b].add(new index(a, d*2-1));
                }
                else{
                    link[a].add(new index(b, d*2));
                    link[b].add(new index(a, d*2));
                }
            }
            int[] cost = new int[n+1];
            boolean[] visited = new boolean[n+1];
            Arrays.fill(cost, 12345678);
            PriorityQueue<index> queue = new PriorityQueue<>();
            queue.add(new index(start, 0));
            cost[start] = 0;

            ArrayList<Integer> destinations = new ArrayList<>(t);
            while ((t--) > 0) {
                destinations.add(Integer.parseInt(br.readLine()));
            }
            while(!queue.isEmpty()){
                index tmp = queue.poll();
                int now = tmp.end;

                if(!visited[now]) visited[now] = true;

                for(int i=0; i<link[now].size(); i++){
                    int next = link[now].get(i).end;
                    int value = link[now].get(i).cost;

                    if(!visited[next] && cost[now] + value < cost[next]){
                        cost[next] = cost[now] + value;
                        queue.add(new index(next, cost[next]));
                    }
                }
            }
            Collections.sort(destinations);

            for (Integer destination : destinations) {
                if(cost[destination] % 2 != 0) System.out.println(destination);
            }

        }
    }
    public static class index implements Comparable<index>{
        int end;
        int cost;

        public index(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(index o) {
            return this.cost - o.cost;
        }
    }
}