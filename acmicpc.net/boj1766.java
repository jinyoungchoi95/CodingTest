import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj1766 {
    public static int N, M;
    public static int[] count;
    public static ArrayList<Integer>[] list;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        count = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list[A].add(B);
            count[B]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            if(count[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            sb.append(tmp + " ");
            for(int i=0; i<list[tmp].size(); i++){
                int next = list[tmp].get(i);
                count[next]--;
                if(count[next]==0) queue.add(next);
            }
        }
        System.out.println(sb.toString());
    }
}
