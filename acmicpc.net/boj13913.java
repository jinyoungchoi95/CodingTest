import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj13913 {
    public static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int[] parent = new int[100001];
        int[] visited = new int[100001];
        visited[N] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()){
            int now = queue.poll();

            int next = 0;
            //+1
            next = now + 1;
            if(next <= 100000 && visited[next]==0){
                queue.add(next);
                parent[next] = now;
                visited[next] = visited[now]+1;
            }
            //-1
            next = now - 1;
            if(0 <= next && visited[next]==0){
                queue.add(next);
                parent[next] = now;
                visited[next] = visited[now]+1;
            }
            //*2
            next = now<<1;
            if(next <= 100000 && visited[next]==0){
                queue.add(next);
                parent[next] = now;
                visited[next] = visited[now]+1;
            }
            if(visited[K]!=0)break;
        }
        System.out.println(visited[K]-1);
        Stack<Integer> answer = new Stack<>();
        int index = K;
        while(visited[index] != 1){
            answer.add(index);
            index = parent[index];
        }
        answer.add(index);
        while(!answer.isEmpty()){
            System.out.printf("%d ", answer.pop());
        }
    }
}