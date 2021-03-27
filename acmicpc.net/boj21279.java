import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj21279 {
    public static int N, C;
    public static ArrayList<index> dia = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            dia.add(new index(x,y,v));
        }
        Collections.sort(dia, new Comparator<index>() {
            @Override
            public int compare(index o1, index o2) {
                if(o1.x==o2.x) return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });
        int currentC = 0;
        long currentV = 0;
        long answer = 0;
        PriorityQueue<index> queue = new PriorityQueue<>();

        for(int i=0; i<dia.size(); i++){
            index now = dia.get(i);
            currentC = queue.size();
            if(currentC < C){
                queue.add(now);
                currentV += now.value;
            }
            else{
                if(queue.peek().y < now.y) continue;
                else if(queue.peek().y == now.y){
                    while(queue.peek().y < now.y){
                        currentV -= queue.poll().value;
                    }
                }
                else{
                    currentV -= queue.poll().value;
                    currentV += now.value;
                    queue.add(now);
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
