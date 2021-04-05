import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11779 {
    public static int n, m;
    public static ArrayList<index>[] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        bus = new ArrayList[n+1];
        record[] records = new record[n+1];
        for(int i=1; i<=n; i++){
            bus[i] = new ArrayList<>();
            records[i] = new record("", Integer.MAX_VALUE);
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            bus[a].add(new index(b, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        records[start] = new record(String.valueOf(start), 0);

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == end) continue;

            for(int i=0; i<bus[now].size(); i++){
                int next = bus[now].get(i).end;
                int nextValue = bus[now].get(i).value;

                if(records[now].cost + nextValue < records[next].cost){
                    records[next] = new record(records[now].answer+" "+String.valueOf(next), records[now].cost + nextValue);
                    queue.add(next);
                }
            }
        }
        System.out.println(records[end].cost);
        String[] answer = records[end].answer.split(" ");
        System.out.println(answer.length);
        for(int i=0; i<answer.length; i++){
            System.out.printf("%s ", answer[i]);
        }
    }
    public static class record{
        String answer;
        int cost;

        public record(String answer, int cost) {
            this.answer = answer;
            this.cost = cost;
        }
    }
    public static class index{
        int end;
        int value;

        public index(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
}
