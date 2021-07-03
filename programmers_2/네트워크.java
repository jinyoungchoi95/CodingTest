import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(computers, i, n);
                answer++;
            }
        }

        return answer;
    }
    public void bfs(int[][] computers, int index, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i<n; i++){
                if(computers[now][i]==0) continue;
                if(visited[i]) continue;
                visited[i] = true;
                queue.add(i);
            }
        }
    }
}