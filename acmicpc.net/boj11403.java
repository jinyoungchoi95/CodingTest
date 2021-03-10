import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj11403 {
    public static int N;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i=0; i<N; i++){
            bfs(i);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        for(int j=0; j<N; j++){
            if(map[start][j]==1){
                queue.add(j);
                visited[j] = true;
            }
        }
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int j=0; j<N; j++){
                if(map[tmp][j]==1 && !visited[j]){
                    visited[j] = true;
                    map[start][j] = 1;
                    queue.add(j);
                }
            }
        }
    }
}
