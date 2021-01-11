import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean[][] relation;
    public int[] map;
    public boolean[] visited;
    public int max = 0;
    public int solution(int n, int[][] edge) {
        int answer = 0;

        relation = new boolean[n+1][n+1];
        map = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            relation[a][b] = relation[b][a] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            max = Math.max(max, map[tmp]);
            for(int i=1; i<=n; i++){
                if(relation[tmp][i] && !visited[i]){
                    visited[i] = true;
                    map[i] = map[tmp]+1;
                    queue.add(i);
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(map[i]==max) answer++;
        }

        return answer;
    }
}