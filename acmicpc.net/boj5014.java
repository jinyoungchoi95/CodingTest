import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj5014 {
    public static int F, S, G, U, D;
    public static int[] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);

        value = new int[F+1];

        bfs(S);
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        value[start] = 1;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(tmp==G){
                System.out.println(value[tmp]-1);
                return;
            }
            if(tmp+U<=F && value[tmp+U]==0){
                value[tmp+U] = value[tmp]+1;
                queue.add(tmp+U);
            }
            if(tmp-D>0 && value[tmp-D]==0){
                value[tmp-D] = value[tmp]+1;
                queue.add(tmp-D);
            }
        }
        System.out.println("use the stairs");
        return;
    }
}
