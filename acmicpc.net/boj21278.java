import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj21278 {
    public static int N, M;
    public static ArrayList<Integer>[] link;
    public static ArrayList<Index> answer = new ArrayList<>();
    public static int min_count, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        link = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            link[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            link[a].add(b);
            link[b].add(a);
        }

        A = 0;
        B = 0;
        min_count = Integer.MAX_VALUE;
        for(int i=1; i<N; i++){
            for(int j=i+1; j<=N; j++){
                makeChickenHouse(i, j);
            }
        }
        System.out.printf("%d %d %d", A, B, min_count);
        System.out.println();
    }
    public static void makeChickenHouse(int house1, int house2){
        int[] time = new int[N+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(house1);
        queue.add(house2);
        time[house1] = time[house2] = 0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i=0; i<link[tmp].size(); i++){
                int next = link[tmp].get(i);
                if(time[tmp] + 2 < time[next]){
                    time[next] = time[tmp] + 2;
                    queue.add(next);
                }
            }
        }
        int count = 0;
        for(int i=1; i<=N; i++){
            count += time[i];
        }
        if(count < min_count){
            A = house1;
            B = house2;
            min_count = count;
        }
    }
    public static class Index {
        int house1;
        int house2;
        int time;
        public Index(int house1, int house2, int time) {
            this.house1 = house1;
            this.house2 = house2;
            this.time = time;
        }
    }
}
