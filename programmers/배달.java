import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            if(map[a][b] == 0){
                map[a][b] = map[b][a] = c;
            }
            else{
                map[a][b] = Math.min(map[a][b], c);
                map[b][a] = Math.min(map[b][a], c);
            }
        }
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return Integer.compare(distance[o1], distance[o2]);
            }
        });
        distance[1] = 0;
        heap.add(1);

        while(!heap.isEmpty()){
            int tmp = heap.poll();
            if(visited[tmp]) continue;
            visited[tmp] = true;

            for(int i=1; i<=N; i++){
                if(map[tmp][i]==0) continue;

                if(distance[i] > distance[tmp] + map[tmp][i]){
                    distance[i] = distance[tmp] + map[tmp][i];
                    heap.add(i);
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(distance[i]<=K) answer++;
        }


        return answer;
    }
}