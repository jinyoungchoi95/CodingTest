import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj13549 {
    public static int N, K;
    public static int[] value = new int[100001];
    public static int answer = 100000;
    public static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();

            if(value[tmp] > answer) continue;
            if(tmp == K){
                answer = Math.min(answer, value[tmp]);
                continue;
            }

            if(tmp*2 <= 100000 && !visited[tmp*2]){
                visited[tmp*2] = true;
                value[tmp*2] = value[tmp];
                queue.add(tmp*2);
            }
            if(tmp >=1 && !visited[tmp-1]){
                visited[tmp-1] = true;
                value[tmp-1] = value[tmp]+1;
                queue.add(tmp-1);
            }
            if(tmp <= 99999 && !visited[tmp+1]){
                visited[tmp+1] = true;
                value[tmp+1] = value[tmp]+1;
                queue.add(tmp+1);
            }
        }
        System.out.println(answer);
    }
}
