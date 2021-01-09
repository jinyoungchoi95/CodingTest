import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int answer;
    public int solution(int n, int[][] results) {
        answer = 0;

        for(int i=1; i<=n; i++){
            bfs(n, results, i);
        }

        return answer;
    }
    public void bfs(int n, int[][] results, int index){
        int result = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        boolean[] visited = new boolean[n+1];

        //find-upscale
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            result++;
            for(int i=0; i<results.length; i++){
                int up = results[i][0];

                if(results[i][1]==tmp && !visited[up]){
                    visited[up] = true;
                    queue.add(up);
                }
            }
        }
        //find-downscale
        queue.add(index);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            result++;
            for(int i=0; i<results.length; i++){
                int down = results[i][1];

                if(results[i][0]==tmp && !visited[down]){
                    visited[down] = true;
                    queue.add(down);
                }
            }
        }

        if(result==n) answer++;
    }
}