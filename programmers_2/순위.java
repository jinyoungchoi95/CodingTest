import java.util.*;

class Solution {
    public List<Integer>[] win;
    public List<Integer>[] lose;
    public int solution(int n, int[][] results) {
        int answer = 0;
        win = new List[n+1];
        lose = new List[n+1];
        for(int i=1; i<=n; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        for(int i=0; i<results.length; i++){
            int a = results[i][0];
            int b = results[i][1];

            win[a].add(b);
            lose[b].add(a);
        }

        for(int i=1; i<=n; i++){
            if(bfs(win, i, n) + bfs(lose, i, n) + 1 == n) answer++;
        }

        return answer;
    }

    public int bfs(List<Integer>[] map, int start, int n) {
        int result = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i<map[now].size(); i++){
                int next = map[now].get(i);

                if(visited[next]) continue;
                visited[next] = true;
                result++;
                queue.add(next);
            }
        }
        return result;
    }
}