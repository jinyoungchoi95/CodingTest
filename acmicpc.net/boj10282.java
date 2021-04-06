import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj10282 {
    public static int n, d, c;
    public static ArrayList<Node>[] link;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test=0; test<T; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            link = new ArrayList[n+1];
            for(int i=0; i<=n; i++){
                link[i] = new ArrayList<>();
            }
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                link[b].add(new Node(a, s));
            }

            PriorityQueue<Node> queue = new PriorityQueue<>();
            int[] value = new int[n+1];
            Arrays.fill(value, Integer.MAX_VALUE);
            value[c] = 0;
            queue.add(new Node(c, 0));
            while(!queue.isEmpty()){
                int now = queue.poll().a;

                for(int i=0; i<link[now].size(); i++){
                    int next = link[now].get(i).a;
                    int scd = link[now].get(i).s;

                    if(value[now]+scd < value[next]){
                        value[next] = value[now]+scd;
                        queue.add(new Node(next, value[next]));
                    }
                }
            }
            int[] answer = new int[2];
            for(int i=1; i<=n; i++){
                if(value[i] != Integer.MAX_VALUE){
                    answer[0]++;
                    answer[1] = Math.max(answer[1], value[i]);
                }
            }
            System.out.printf("%d %d\n", answer[0], answer[1]);
        }
    }
    public static class Node implements Comparable<Node> {
        int a;
        int s;

        public Node(int a, int s) {
            this.a = a;
            this.s = s;
        }

        @Override
        public int compareTo(Node o) {
            return this.s - o.s;
        }
    }
}
