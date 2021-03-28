import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj21279 {
    public static int N, C;
    public static ArrayList<index>[] xIndex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        xIndex = new ArrayList[100005];
        for(int i=0; i<xIndex.length; i++){
            xIndex[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            xIndex[x].add(new index(x, y, value));
        }
        long answer = 0;
        long currentV = 0L;
        PriorityQueue<index> queue = new PriorityQueue<>();
        for(int i=0; i<xIndex.length; i++){
            if(xIndex[i].isEmpty()) continue;
            for(int j=0; j<xIndex[i].size(); j++){
                queue.add(xIndex[i].get(j));
                currentV += xIndex[i].get(j).value;
            }
            int prevTop = -1;
            while(!queue.isEmpty() && queue.size()>C){
                prevTop = queue.peek().y;
                currentV -= queue.poll().value;
                while(!queue.isEmpty() && queue.peek().y == prevTop){
                    currentV -= queue.poll().value;
                }
            }
            answer = Math.max(answer, currentV);
        }
        System.out.println(answer);
    }
    public static class index implements Comparable<index> {
        int x;
        int y;
        long value;

        public index(int x, int y, long value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(index o) {
            return o.y - this.y;
        }
    }

}
