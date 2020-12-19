import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj1707 {
    public static int K, V, E;
    public static int value[];
    public static ArrayList<Integer>[] map;
    public static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        for(int testcase=0; testcase<K; testcase++){
            String[] input = br.readLine().split(" ");
            V = Integer.parseInt(input[0]);
            E = Integer.parseInt(input[1]);
            value = new int[V+1];
            map = new ArrayList[V+1];
            for(int i=1; i<=V; i++){
                map[i] = new ArrayList<Integer>();
            }
            for(int i=0; i<E; i++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                map[a].add(b);
                map[b].add(a);
            }
            answer = "YES";
            for(int i=1; i<=V; i++){
                if(value[i]==0){
                    if(!bfs(i)) break;
                }
            }
            System.out.println(answer);
        }
    }
    public static boolean bfs(int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        value[index] = 1;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i=0; i<map[tmp].size(); i++){
                int tmp2 = map[tmp].get(i);

                if(value[tmp]==value[tmp2]){
                    answer = "NO";
                    return false;
                }

                if(value[tmp2]==0){
                    value[tmp2] = value[tmp] * -1;
                    queue.add(tmp2);
                }
            }
        }
        return true;
    }


}