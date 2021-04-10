import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj14226 {
    public static int S;
    public static boolean[][] visited = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited[1][0] = true;
        Queue<index> queue = new LinkedList<>();
        queue.add(new index(1, 0, 0));

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            if(tmp.now == S){
                System.out.println(tmp.time);
                return;
            }

            if(tmp.now!=0 && !visited[tmp.now][tmp.now]){
                visited[tmp.now][tmp.now] = true;
                queue.add(new index(tmp.now, tmp.now, tmp.time+1));
            }


            if(tmp.saved!=0 && tmp.now + tmp.saved <= 1000 && !visited[tmp.now+tmp.saved][tmp.saved] ){
                visited[tmp.now+tmp.saved][tmp.saved] = true;
                queue.add(new index(tmp.now+tmp.saved, tmp.saved, tmp.time+1));
            }

            if(tmp.now >0 && tmp.now-1 <= 1000 && !visited[tmp.now-1][tmp.saved]){
                visited[tmp.now-1][tmp.saved] = true;
                queue.add(new index(tmp.now-1, tmp.saved, tmp.time+1));
            }
        }


    }
    public static class index{
        int now;
        int saved;
        int time;

        public index(int now, int saved, int time) {
            this.now = now;
            this.saved = saved;
            this.time = time;
        }
    }
}
