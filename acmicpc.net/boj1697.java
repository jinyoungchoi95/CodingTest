import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj1697 {
    public static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        System.out.println(bfs(N, K));
    }
    public static int bfs(int N, int K){
        Queue<index> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        queue.add(new index(N, 0));
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.n == K){
                return tmp.sec;
            }
            if(tmp.n+1<=100000 && !visited[tmp.n+1]){
                visited[tmp.n+1] = true;
                queue.add(new index(tmp.n+1, tmp.sec+1));
            }

            if(0<=tmp.n-1 && !visited[tmp.n-1]){
                visited[tmp.n-1] = true;
                queue.add(new index(tmp.n-1, tmp.sec+1));
            }

            if(tmp.n*2<=100000 && !visited[tmp.n*2]){
                visited[tmp.n*2] = true;
                queue.add(new index(tmp.n*2, tmp.sec+1));
            }
        }
        return 0;
    }
    public static class index{
        int n;
        int sec;
        public index(int n, int sec){
            this.n = n;
            this.sec = sec;
        }
    }
}
