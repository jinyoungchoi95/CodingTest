import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj9372 {
    public static int N, M;
    public static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            map = new boolean[N+1][N+1];
            for(int i=0; i<M; i++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                map[a][b] = map[b][a] = true;
            }
            boolean[] visited = new boolean[N+1];
            Queue<Integer> queue = new LinkedList<>();
            visited[1] = true;
            queue.add(1);
            int answer = 0;
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                for(int i=1; i<=N; i++){
                    if(!visited[i] && map[i][tmp]){
                        answer++;
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
