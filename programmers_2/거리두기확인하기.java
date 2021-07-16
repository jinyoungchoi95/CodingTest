import java.util.*;

class Solution {
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        for(int t=0; t<places.length; t++){
            boolean check = true;
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(places[t][i].charAt(j) == 'P' && bfs(i, j, places, t)) {
                        answer[t] = 0;
                        check = false;
                        break;
                    }
                }
                if(!check) break;
            }
        }

        return answer;
    }
    public boolean bfs(int x, int y, String[][] places, int t) {
        Queue<Index> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        queue.add(new Index(x, y, 0));
        while(!queue.isEmpty()){
            Index now = queue.poll();

            if(now.count >= 1 && places[t][now.x].charAt(now.y) == 'P') {
                return true;
            }
            if(now.count == 2){
                continue;
            }
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;
                if(visited[nx][ny]) continue;
                if(places[t][nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                queue.add(new Index(nx, ny, now.count+1));
            }

        }
        return false;
    }
    public class Index{
        int x;
        int y;
        int count;
        public Index(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}