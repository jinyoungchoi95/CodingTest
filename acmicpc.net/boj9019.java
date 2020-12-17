import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj9019 {
    public static int A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int testcase=0; testcase<T; testcase++){
            String[] input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);

            boolean[] visited = new boolean[10000];
            String[] value = new String[10000];
            Arrays.fill(value, "");
            visited[A] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(A);
            while(!queue.isEmpty() || !visited[B]){
                int now = queue.poll();
                int D = (2*now)%10000;
                int S = (now == 0) ? 9999 : now-1;
                int L = (now % 1000) * 10 + now/1000;
                int R = (now % 10) * 1000 + now/10;
                if(!visited[D]){
                    visited[D] = true;
                    queue.add(D);
                    value[D] = value[now]+"D";
                }
                if(!visited[S]){
                    visited[S] = true;
                    queue.add(S);
                    value[S] = value[now]+"S";
                }
                if(!visited[L]){
                    visited[L] = true;
                    queue.add(L);
                    value[L] = value[now]+"L";
                }
                if(!visited[R]){
                    visited[R] = true;
                    queue.add(R);
                    value[R] = value[now]+"R";
                }
            }

            System.out.println(value[B]);
        }
    }
}
