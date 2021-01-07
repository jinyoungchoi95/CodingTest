import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(n, computers, i);
                answer++;
            }
        }

        return answer;
    }
    public void bfs(int n, int[][] computers, int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            for(int i=0; i<n; i++){
                if(computers[tmp][i]==1 && !visited[i]){
                    queue.add(i);
                }
            }
        }
    }
}